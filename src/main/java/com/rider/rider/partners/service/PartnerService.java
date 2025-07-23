package com.rider.rider.partners.service;

import com.rider.rider.locations.entity.Location;
import com.rider.rider.partners.dto.normal.PartnerNormal;
import com.rider.rider.partners.dto.request.AttachPartnerToRideRequest;
import com.rider.rider.partners.dto.request.CreatePartnerRequest;
import com.rider.rider.partners.dto.request.GetNearbyAvailablePartnersRequest;
import com.rider.rider.partners.dto.response.CreatePartnerResponse;
import com.rider.rider.partners.dto.response.GetNearbyAvailablePartnersResponse;
import com.rider.rider.partners.dto.response.GetPartnerByIdResponse;
import com.rider.rider.partners.entity.Partner;
import com.rider.rider.partners.enums.PartnerCurrentStatus;
import com.rider.rider.partners.repository.PartnerRepository;
import com.rider.rider.partners.utils.mapper.PartnerMapper;
import com.rider.rider.rides.dto.responses.GetRideResponse;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.rides.service.RideService;
import com.rider.rider.rides.util.mapper.RideMapper;
import com.rider.rider.users.entity.User;
import com.rider.rider.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.rider.rider.rides.util.base.DistanceCalculator.calculateDistance;

@Service
public class PartnerService implements PartnerServiceInterface {
    private final PartnerRepository partnerRepository;
    private final UserService userService;
    private final RideService rideService;

    public PartnerService(PartnerRepository partnerRepository, UserService userService, RideService rideService) {
        this.partnerRepository = partnerRepository;
        this.userService = userService;
        this.rideService = rideService;
    }

    @Override
    public CreatePartnerResponse createPartner(CreatePartnerRequest createPartnerRequest) {
        Partner partner = new Partner();

        //partner location
        Location partnerLocation = new Location();
        partnerLocation.setLatitude(createPartnerRequest.getPartnerLocationLatitude());
        partnerLocation.setLongitude(createPartnerRequest.getPartnerLocationLongitude());

        //user
        User user = userService.getUserById(UUID.fromString(createPartnerRequest.getUserId())).orElseThrow(() -> new RuntimeException("User not found"));

        partner.setUser(user);
        partner.setRating(0.0);
        partner.setTotalRidesCompleted(0);
        partner.setCurrentLocation(partnerLocation);

        Partner savedPartner = this.partnerRepository.save(partner);
        return new CreatePartnerResponse(savedPartner.getId().toString());
    }

    @Override
    public GetPartnerByIdResponse getPartnerById(String partnerId) {
        Partner partner = this.partnerRepository.findById(UUID.fromString(partnerId)).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner not found"));
        PartnerNormal partnerNormal = PartnerMapper.toNormal(partner);
        return new GetPartnerByIdResponse(partnerNormal);
    }

    public void attachPartnerToRide(AttachPartnerToRideRequest attachPartnerToRideRequest) {
        System.out.println("partner id: " + attachPartnerToRideRequest.getPartnerId());
        if (attachPartnerToRideRequest.getPartnerId() == null || attachPartnerToRideRequest.getRideId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Partner ID and Ride ID must not be null");
        }

        UUID partnerId = UUID.fromString(attachPartnerToRideRequest.getPartnerId());

        Partner partner = this.partnerRepository.findById(partnerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Partner not found"));

        GetRideResponse getRideResponse = this.rideService.getRideById(attachPartnerToRideRequest.getRideId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ride not found"));

        Ride ride = RideMapper.toEntity(getRideResponse.getRideNormal());

        partner.setCurrentRide(ride);
        partner.setPartnerCurrentStatus(PartnerCurrentStatus.OCCUPIED);

        this.partnerRepository.save(partner);
    }

    public void updatePartnerEntity(Partner partner) {
        this.partnerRepository.save(partner);
    }

    public GetNearbyAvailablePartnersResponse getNearbyAvailablePartners(GetNearbyAvailablePartnersRequest getNearbyAvailablePartnersRequest) {
        double radiusInKm = 10.0;
        System.out.println("SL: " + getNearbyAvailablePartnersRequest.getSourceLatitude() + "-> " + getNearbyAvailablePartnersRequest.getSourceLongitude());
        List<Partner> allPartners = partnerRepository.findAllWithLocation();
        List<Partner> nearbyPartners = new ArrayList<>();

        for (Partner partner : allPartners) {
            Location location = partner.getCurrentLocation();
            if (location != null && partner.getPartnerCurrentStatus() == PartnerCurrentStatus.AVAILABLE) {
                double distance = calculateDistance(getNearbyAvailablePartnersRequest.getSourceLatitude(), getNearbyAvailablePartnersRequest.getSourceLongitude(),
                        location.getLatitude(), location.getLongitude());
                if (distance <= radiusInKm) {
                    nearbyPartners.add(partner);
                }
            }
        }

        List<PartnerNormal> partnerNormals =
                nearbyPartners.stream()
                        .map(PartnerMapper::toNormal)
                        .collect(Collectors.toList());

        return new GetNearbyAvailablePartnersResponse(partnerNormals);
    }
}
