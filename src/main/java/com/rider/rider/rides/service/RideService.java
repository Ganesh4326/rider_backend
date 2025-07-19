package com.rider.rider.rides.service;

import com.rider.rider.partners.dto.normal.PartnerNormal;
import com.rider.rider.partners.dto.request.AttachPartnerToRideRequest;
import com.rider.rider.partners.dto.response.GetPartnerByIdResponse;
import com.rider.rider.partners.entity.Partner;
import com.rider.rider.partners.service.PartnerService;
import com.rider.rider.partners.utils.mapper.PartnerMapper;
import com.rider.rider.rides.dto.normals.RideLocationNormal;
import com.rider.rider.rides.dto.normals.RideNormal;
import com.rider.rider.rides.dto.normals.RidePaymentNormal;
import com.rider.rider.rides.dto.normals.RideTrackingNormal;
import com.rider.rider.rides.dto.requests.AttachRideToPartnerRequest;
import com.rider.rider.rides.dto.requests.CreateRideEventRequest;
import com.rider.rider.rides.dto.requests.CreateRideRequest;
import com.rider.rider.rides.dto.requests.UpdateRideStatusRequest;
import com.rider.rider.rides.dto.responses.CreateRideResponse;
import com.rider.rider.rides.dto.responses.GetRideResponse;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.rides.entity.RideLocation;
import com.rider.rider.rides.entity.RidePayment;
import com.rider.rider.rides.entity.RideTracking;
import com.rider.rider.rides.enums.RideLocationType;
import com.rider.rider.rides.enums.RidePaymentStatus;
import com.rider.rider.rides.enums.RideStatus;
import com.rider.rider.rides.repository.RideRepository;
import com.rider.rider.users.dto.normals.UserNormal;
import com.rider.rider.users.entity.User;
import com.rider.rider.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RideService {
    public final RideRepository rideRepository;
    public final UserService userService;
    public final RideEventService rideEventService;
    public final PartnerService partnerService;

    public RideService(RideRepository rideRepository, UserService userService, RideEventService rideEventService, PartnerService partnerService) {
        this.rideRepository = rideRepository;
        this.userService = userService;
        this.rideEventService = rideEventService;
        this.partnerService = partnerService;
    }

    public static BigDecimal getEstimatedFare() {
        BigDecimal baseFare = new BigDecimal("30.0");           // ₹30
        BigDecimal costPerKm = new BigDecimal("10.0");          // ₹10 per km
        BigDecimal costPerMinute = new BigDecimal("2.0");       // ₹2 per min
        BigDecimal surgeMultiplier = new BigDecimal("1.5");     // 1.5x surge pricing
        BigDecimal serviceFee = new BigDecimal("5.0");          // Optional platform fee

        double distanceInKm = 8.2;      // From pickup to drop
        long durationInMinutes = 18;    // Estimated duration

        BigDecimal distanceFare = costPerKm.multiply(BigDecimal.valueOf(distanceInKm));
        BigDecimal timeFare = costPerMinute.multiply(BigDecimal.valueOf(durationInMinutes));

        BigDecimal estimatedFare = baseFare
                .add(distanceFare)
                .add(timeFare)
                .multiply(surgeMultiplier)
                .add(serviceFee);

        System.out.println("Estimated Fare = ₹" + estimatedFare.setScale(2, RoundingMode.HALF_UP));
//        Estimated Fare =
//                (baseFare + distance * costPerKm + duration * costPerMinute) * surge + serviceFee
        return estimatedFare.setScale(2, RoundingMode.HALF_UP);
    }

    public CreateRideResponse createRide(CreateRideRequest createRideRequest) {
        Ride ride = new Ride();

        //user
//        User user = userService.getUserById(createRideRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        //pick up location
        RideLocation pickupRideLocation = new RideLocation();
        pickupRideLocation.setLatitude(createRideRequest.getPickupLatitude());
        pickupRideLocation.setLongitude(createRideRequest.getPickupLongitude());
        pickupRideLocation.setLocationType(RideLocationType.PICKUP);

        //drop location
        RideLocation dropRideLocation = new RideLocation();
        dropRideLocation.setLatitude(createRideRequest.getDropLatitude());
        dropRideLocation.setLongitude(createRideRequest.getDropLongitude());
        dropRideLocation.setLocationType(RideLocationType.DROP);

        //payment
        RidePayment ridePayment = new RidePayment();
        ridePayment.setEstimatedFare(getEstimatedFare());
        ridePayment.setRide(ride);
        ridePayment.setRidePaymentStatus(RidePaymentStatus.PENDING);

        ride.setLocations(List.of(pickupRideLocation, dropRideLocation));
        ride.setRidePayment(ridePayment);
        ride.setEstimatedDuration(Duration.ofMinutes(15));
        ride.setRideStatus(RideStatus.REQUESTED);
//        ride.setUser(user);

        pickupRideLocation.setRide(ride);
        dropRideLocation.setRide(ride);

        Ride savedRide = rideRepository.save(ride);

        //creating Ride event
        CreateRideEventRequest createRideEventRequest = new CreateRideEventRequest();
        createRideEventRequest.setRideId(savedRide.getRideId());
        createRideEventRequest.setRideEventType(savedRide.getRideStatus());

        this.rideEventService.createRideEvent(createRideEventRequest);

        return new CreateRideResponse(savedRide.getRideId());
    }

    public Optional<GetRideResponse> getRideById(UUID rideId) {
        return rideRepository.findById(rideId).map(ride -> {
//            User user = userService.getUserById(ride.getUser().getId()).orElseThrow();
            RideNormal rideNormal = new RideNormal(
                    rideId,
                    new UserNormal(),
                    new PartnerNormal(),
                    ride.getCreatedTime(),
                    ride.getUpdatedTime(),
                    ride.getStartTime(),
                    ride.getEndTime(),
                    ride.getRequestedTime(),
                    ride.getAcceptedTime(),
                    ride.getStatus(),
                    ride.getRideType(),
                    ride.getDropAddress(),
                    ride.getPickupAddress(),
                    ride.getLocations().stream()
                            .filter(loc -> loc.getLocationType() == RideLocationType.PICKUP)
                            .findFirst()
                            .map(this::mapToRideLocationNormal)
                            .orElse(null),
                    ride.getLocations().stream()
                            .filter(loc -> loc.getLocationType() == RideLocationType.DROP)
                            .findFirst()
                            .map(this::mapToRideLocationNormal)
                            .orElse(null),
                    mapToRideTrackingNormalList(ride.getTracking()),
                    mapToRidePaymentNormal(ride.getRidePayment()),
                    ride.getRideStatus(),
                    ride.getEstimatedDuration(),
                    ride.getActualDuration()
            );
            return new GetRideResponse(rideNormal);
        });
    }

    public void updateRideStatus(UpdateRideStatusRequest updateRideStatusRequest) {
        Ride ride = this.rideRepository.findById(updateRideStatusRequest.getRideId()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ride not found"));
        ride.setRideStatus(updateRideStatusRequest.getRideStatus());
        if (updateRideStatusRequest.getRideStatus() == RideStatus.COMPLETED) {
            ride.setEndTime(LocalDateTime.now());
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
        GetPartnerByIdResponse getPartnerByIdResponse = this.partnerService.getPartnerById(attachRideToPartnerRequest.getPartnerId());
        Partner partner = PartnerMapper.toEntity(getPartnerByIdResponse.getPartnerNormal());
        ride.setPartner(partner);
        ride.setRideStatus(RideStatus.ACCEPTED);

        CreateRideEventRequest createRideEventRequest = new CreateRideEventRequest();
        createRideEventRequest.setRideId(UUID.fromString(attachRideToPartnerRequest.getRideId()));
        createRideEventRequest.setRideEventType(RideStatus.ACCEPTED);
        this.rideEventService.createRideEvent(createRideEventRequest);

        AttachPartnerToRideRequest attachPartnerToRideRequest = new AttachPartnerToRideRequest();
        attachPartnerToRideRequest.setRideId(attachPartnerToRideRequest.getRideId());
        attachPartnerToRideRequest.setPartnerId(attachPartnerToRideRequest.getPartnerId());
        this.partnerService.attachPartnerToRide(attachPartnerToRideRequest);

        this.rideRepository.save(ride);
    }

    public UserNormal mapToUserNormal(User user) {
        UserNormal userNormal = new UserNormal();
        userNormal.setUserId(user.getId());
        userNormal.setName(user.getName());
        userNormal.setPhone(user.getPhone());
        userNormal.setEmail(user.getEmail());
        userNormal.setRole(user.getRole());
        return userNormal;
    }

    private RideLocationNormal mapToRideLocationNormal(RideLocation location) {
        RideLocationNormal rideLocationNormal = new RideLocationNormal();
        rideLocationNormal.setLatitude(location.getLatitude());
        rideLocationNormal.setLongitude(location.getLongitude());
        return rideLocationNormal;
    }

    private RidePaymentNormal mapToRidePaymentNormal(RidePayment ridePayment) {
        RidePaymentNormal ridePaymentNormal = new RidePaymentNormal(
                ridePayment.getRidePaymentId(),
                ridePayment.getRide().getRideId(),
                ridePayment.getEstimatedFare(),
                ridePayment.getActualFare(),
                ridePayment.getRidePaymentMode(),
                ridePayment.getRidePaymentStatus(),
                ridePayment.getPaidAt()
        );
        return ridePaymentNormal;
    }

    public List<RideTrackingNormal> mapToRideTrackingNormalList(List<RideTracking> rideTrackingList) {
        return rideTrackingList.stream()
                .map(rt -> new RideTrackingNormal(
                        rt.getRideTrackingId(),
                        rt.getCreatedTime(),
                        rt.getLatitude(),
                        rt.getLongitude()
                ))
                .collect(Collectors.toList());
    }

}
