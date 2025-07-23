package com.rider.rider.rides.service;

import com.rider.rider.partners.dto.request.GetNearbyAvailablePartnersRequest;
import com.rider.rider.partners.dto.response.GetNearbyAvailablePartnersResponse;
import com.rider.rider.partners.dto.response.GetPartnerByIdResponse;
import com.rider.rider.partners.entity.Partner;
import com.rider.rider.partners.service.PartnerService;
import com.rider.rider.partners.utils.mapper.PartnerMapper;
import com.rider.rider.rides.dto.normals.RideRequestNormal;
import com.rider.rider.rides.dto.requests.AttachPartnerToRideRequestRequest;
import com.rider.rider.rides.dto.requests.CreateRideRequestRequest;
import com.rider.rider.rides.dto.requests.GetRideRequestByIdRequest;
import com.rider.rider.rides.dto.responses.CreateRideRequestResponse;
import com.rider.rider.rides.dto.responses.GetAllRideRequestsResponse;
import com.rider.rider.rides.dto.responses.GetRideRequestByIdResponse;
import com.rider.rider.rides.dto.responses.GetRideResponse;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.rides.entity.RideRequest;
import com.rider.rider.rides.enums.RideRequestStatus;
import com.rider.rider.rides.repository.RideRepository;
import com.rider.rider.rides.repository.RideRequestRepository;
import com.rider.rider.rides.util.mapper.RideMapper;
import com.rider.rider.rides.util.mapper.RideRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RideRequestService {
    @Autowired
    private RideRequestRepository rideRequestRepository;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private RideService rideService;

    @Autowired
    private RideRepository rideRepository;

    public GetRideRequestByIdResponse getRideRequestById(GetRideRequestByIdRequest getRideRequestByIdRequest) {
        RideRequest rideRequest = this.rideRequestRepository.findById(UUID.fromString(getRideRequestByIdRequest.getRideRequestId())).orElseThrow();
        return new GetRideRequestByIdResponse(RideRequestMapper.toNormal(rideRequest));
    }

    public GetAllRideRequestsResponse getAllRideRequests() {
        List<RideRequest> rideRequests = this.rideRequestRepository.findAll();

        List<RideRequestNormal> rideRequestNormals = rideRequests.stream()
                .map(rr -> RideRequestMapper.toNormal(rr))
                .collect(Collectors.toList());
        return new GetAllRideRequestsResponse(rideRequestNormals);
    }

    public CreateRideRequestResponse createRideRequest(CreateRideRequestRequest createRideRequestRequest) {
        GetRideResponse getRideResponse = this.rideService.getRideById(createRideRequestRequest.getRideId()).orElseThrow();
        Ride ride = RideMapper.toEntity(getRideResponse.getRideNormal());

        System.out.println("RRL:" + createRideRequestRequest.getRideLongitude());

        GetNearbyAvailablePartnersRequest getNearbyAvailablePartnersRequest =
                new GetNearbyAvailablePartnersRequest(createRideRequestRequest.getRideLatitude(), createRideRequestRequest.getRideLongitude());

        System.out.println("RRL2:" + getNearbyAvailablePartnersRequest.getSourceLongitude());

        GetNearbyAvailablePartnersResponse getNearbyAvailablePartnersResponse =
                this.partnerService.getNearbyAvailablePartners(getNearbyAvailablePartnersRequest);
        List<Partner> partners = getNearbyAvailablePartnersResponse.getPartnersList().stream()
                .map(PartnerMapper::toEntity).toList();

        RideRequest rideRequest = new RideRequest();
        rideRequest.setRide(ride);
        rideRequest.setNearbyPartners(new ArrayList<>(partners));
        rideRequest.setRideRequestStatus(RideRequestStatus.CREATED);

        RideRequest savedRideRequest = this.rideRequestRepository.save(rideRequest);
        return new CreateRideRequestResponse(savedRideRequest.getId().toString());
    }

    public void attachPartnerToRideRequest(AttachPartnerToRideRequestRequest attachPartnerToRideRequestRequest) {
        RideRequest rideRequest =
                this.rideRequestRepository.findById(UUID.fromString(attachPartnerToRideRequestRequest.getRideRequestId())).orElseThrow();
        GetPartnerByIdResponse getPartnerByIdResponse =
                this.partnerService.getPartnerById(attachPartnerToRideRequestRequest.getPartnerId());
        Partner partner = PartnerMapper.toEntity(getPartnerByIdResponse.getPartnerNormal());

        rideRequest.setAcceptedPartner(partner);
        rideRequest.setRideRequestStatus(RideRequestStatus.ACCEPTED);
        this.rideRequestRepository.save(rideRequest);
    }
}
