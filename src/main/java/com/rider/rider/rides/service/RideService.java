package com.rider.rider.rides.service;

import com.rider.rider.locations.entity.Location;
import com.rider.rider.partners.dto.request.AttachPartnerToRideRequest;
import com.rider.rider.partners.entity.Partner;
import com.rider.rider.partners.repository.PartnerRepository;
import com.rider.rider.partners.service.PartnerService;
import com.rider.rider.payments.entity.Payment;
import com.rider.rider.payments.enums.PaymentStatus;
import com.rider.rider.rides.dto.normals.RideNormal;
import com.rider.rider.rides.dto.requests.*;
import com.rider.rider.rides.dto.responses.CreateRideRequestResponse;
import com.rider.rider.rides.dto.responses.CreateRideResponse;
import com.rider.rider.rides.dto.responses.GetAllRidesResponse;
import com.rider.rider.rides.dto.responses.GetRideResponse;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.rides.entity.RideLocationInfo;
import com.rider.rider.rides.entity.RidePaymentInfo;
import com.rider.rider.rides.entity.RideTimingInfo;
import com.rider.rider.rides.enums.RideStatus;
import com.rider.rider.rides.repository.RideRepository;
import com.rider.rider.rides.util.base.FareCalculator;
import com.rider.rider.rides.util.mapper.RideMapper;
import com.rider.rider.users.entity.User;
import com.rider.rider.users.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RideService {
    public final RideRepository rideRepository;
    public final UserService userService;
    public final RideEventService rideEventService;
    public final PartnerRepository partnerRepository;
    public final PartnerService partnerService;

    @Autowired
    private @Lazy RideRequestService rideRequestService;

    public RideService(RideRepository rideRepository, UserService userService, RideEventService rideEventService, PartnerRepository partnerRepository, @Lazy PartnerService partnerService) {
        this.rideRepository = rideRepository;
        this.userService = userService;
        this.rideEventService = rideEventService;
        this.partnerRepository = partnerRepository;
        this.partnerService = partnerService;
    }

    public GetAllRidesResponse getAllRides() {
        List<Ride> rides = this.rideRepository.findAll();
        List<RideNormal> rideNormalList = rides.stream().map(RideMapper::toNormal).toList();
        return new GetAllRidesResponse(rideNormalList);
    }

    public CreateRideResponse createRide(CreateRideRequest createRideRequest) {
        Ride ride = new Ride();

        //user
        User user = userService.getUserById(UUID.fromString(createRideRequest.getUserId())).orElseThrow(() -> new RuntimeException("User not found"));

        //pick up location
        Location pickupRideLocation = new Location();
        pickupRideLocation.setLatitude(createRideRequest.getPickupLatitude());
        pickupRideLocation.setLongitude(createRideRequest.getPickupLongitude());

        //drop location
        Location dropRideLocation = new Location();
        dropRideLocation.setLatitude(createRideRequest.getDropLatitude());
        dropRideLocation.setLongitude(createRideRequest.getDropLongitude());

        //ride location info
        RideLocationInfo rideLocationInfo = new RideLocationInfo();
        rideLocationInfo.setPickupLocation(pickupRideLocation);
        rideLocationInfo.setDropLocation(dropRideLocation);

        //ride timing info
        RideTimingInfo rideTimingInfo = new RideTimingInfo();
        rideTimingInfo.setEstimatedTotalDuration(Duration.ofMinutes(15));

        //payment
        Payment payment = new Payment();
        payment.setPaymentStatus(PaymentStatus.PENDING);
        //ride payment info
        RidePaymentInfo ridePaymentInfo = new RidePaymentInfo();
        ridePaymentInfo.setEstimatedFare(FareCalculator.getEstimatedFare());
        ridePaymentInfo.setPayment(payment);

        ride.setUser(user);
        ride.setRideLocationInfo(rideLocationInfo);
        ride.setRidePaymentInfo(ridePaymentInfo);
        ride.setRideTimingInfo(rideTimingInfo);
        ride.setRideStatus(RideStatus.REQUESTED);
        ride.setRideType(createRideRequest.getRideType());

        ridePaymentInfo.setRide(ride);
        rideLocationInfo.setRide(ride);
        rideTimingInfo.setRide(ride);

        //creating ride
        Ride savedRide = rideRepository.save(ride);

        //ride request creation
        CreateRideRequestRequest createRideRequestRequest = new CreateRideRequestRequest();
        createRideRequestRequest.setRideId(savedRide.getId().toString());
        createRideRequestRequest.setRideLatitude(createRideRequest.getPickupLatitude());
        createRideRequestRequest.setRideLongitude(createRideRequest.getPickupLongitude());
        this.rideRequestService.createRideRequest(createRideRequestRequest);

        //creating Ride event
        CreateRideEventRequest createRideEventRequest = new CreateRideEventRequest();
        createRideEventRequest.setRideId(savedRide.getId().toString());
        createRideEventRequest.setRideEventType(savedRide.getRideStatus());

        this.rideEventService.createRideEvent(createRideEventRequest);

        return new CreateRideResponse(savedRide.getId().toString());
    }

    public Optional<GetRideResponse> getRideById(String rideId) {
        return rideRepository.findById(UUID.fromString(rideId)).map(ride -> {
            RideNormal rideNormal = RideMapper.toNormal(ride);
            return new GetRideResponse(rideNormal);
        });
    }

    public void updateRideStatus(UpdateRideStatusRequest updateRideStatusRequest) {
        Ride ride = this.rideRepository.findById(UUID.fromString(updateRideStatusRequest.getRideId())).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ride not found"));
        ride.setRideStatus(updateRideStatusRequest.getRideStatus());
        if (updateRideStatusRequest.getRideStatus() == RideStatus.COMPLETED) {
            if (ride.getRideTimingInfo() == null) {
                ride.setRideTimingInfo(new RideTimingInfo());
            }
            ride.getRideTimingInfo().setEndTime(LocalDateTime.now());
        }
        this.rideRepository.save(ride);

        CreateRideEventRequest createRideEventRequest = new CreateRideEventRequest();
        createRideEventRequest.setRideId(updateRideStatusRequest.getRideId());
        createRideEventRequest.setRideEventType(updateRideStatusRequest.getRideStatus());
        this.rideEventService.createRideEvent(createRideEventRequest);
    }

    public void attachRideToPartner(AttachRideToPartnerRequest attachRideToPartnerRequest) {
        Ride ride = this.rideRepository.findById(UUID.fromString(attachRideToPartnerRequest.getRideId())).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ride not found"));
        Partner partner = this.partnerRepository.findById(UUID.fromString(attachRideToPartnerRequest.getPartnerId())).orElseThrow(() -> new EntityNotFoundException("Partner not found"));
        ride.setPartner(partner);

        ride.setRideStatus(RideStatus.ACCEPTED);

        //creating new ride event
        CreateRideEventRequest createRideEventRequest = new CreateRideEventRequest();
        createRideEventRequest.setRideId(attachRideToPartnerRequest.getRideId());
        createRideEventRequest.setRideEventType(RideStatus.ACCEPTED);
        this.rideEventService.createRideEvent(createRideEventRequest);

        //attach partner to ride
        AttachPartnerToRideRequest attachPartnerToRideRequest = new AttachPartnerToRideRequest();
        attachPartnerToRideRequest.setRideId(attachRideToPartnerRequest.getRideId());
        attachPartnerToRideRequest.setPartnerId(attachRideToPartnerRequest.getPartnerId());
        this.partnerService.attachPartnerToRide(attachPartnerToRideRequest);

        //attach ride to partner
        this.rideRepository.save(ride);
    }
}
