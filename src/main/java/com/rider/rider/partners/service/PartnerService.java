package com.rider.rider.partners.service;

import com.rider.rider.partners.dto.normal.PartnerNormal;
import com.rider.rider.partners.dto.request.AttachPartnerToRideRequest;
import com.rider.rider.partners.dto.request.CreatePartnerRequest;
import com.rider.rider.partners.dto.response.CreatePartnerResponse;
import com.rider.rider.partners.dto.response.GetPartnerByIdResponse;
import com.rider.rider.partners.entity.Partner;
import com.rider.rider.partners.entity.PartnerLocation;
import com.rider.rider.partners.enums.PartnerCurrentStatus;
import com.rider.rider.partners.repository.PartnerRepository;
import com.rider.rider.partners.utils.mapper.PartnerMapper;
import com.rider.rider.rides.dto.responses.GetRideResponse;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.rides.service.RideService;
import com.rider.rider.rides.util.mapper.RideMapper;
import com.rider.rider.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class PartnerService {
    private final PartnerRepository partnerRepository;
    private final UserService userService;
    private final RideService rideService;

    public PartnerService(PartnerRepository partnerRepository, UserService userService, RideService rideService) {
        this.partnerRepository = partnerRepository;
        this.userService = userService;
        this.rideService = rideService;
    }

    public CreatePartnerResponse createPartner(CreatePartnerRequest createPartnerRequest) {
        Partner partner = new Partner();

        //partner location
        PartnerLocation partnerLocation = new PartnerLocation();
        partnerLocation.setLatitude(createPartnerRequest.getPartnerLocationLatitude());
        partnerLocation.setLongitude(createPartnerRequest.getPartnerLocationLongitude());

        //user
//        User user = userService.getUserById(createPartnerRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        partner.setRating(0.0);
        partner.setTotalRidesCompleted(0);
        partner.setPartnerLocation(partnerLocation);

        partnerLocation.setPartner(partner);

        Partner savedPartner = this.partnerRepository.save(partner);
        return new CreatePartnerResponse(savedPartner.getPartnerId());
    }

    public GetPartnerByIdResponse getPartnerById(String partnerId) {
        Partner partner = this.partnerRepository.findById(UUID.fromString(partnerId)).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner not found"));
        PartnerNormal partnerNormal = PartnerMapper.toNormal(partner);
        return new GetPartnerByIdResponse(partnerNormal);
    }

    public void attachPartnerToRide(AttachPartnerToRideRequest attachPartnerToRideRequest) {
        Partner partner = this.partnerRepository.findById(attachPartnerToRideRequest.getPartnerId()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner not found"));

        GetRideResponse getRideResponse = this.rideService.getRideById(attachPartnerToRideRequest.getRideId()).orElse(null);
        Ride ride = RideMapper.toEntity(getRideResponse.getRideNormal());

        partner.setCurrentRide(ride);
        partner.setPartnerCurrentStatus(PartnerCurrentStatus.OCCUPIED);

        this.partnerRepository.save(partner);
    }
}
