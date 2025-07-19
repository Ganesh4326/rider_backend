package com.rider.rider.rides.util.mapper;

import com.rider.rider.partners.utils.mapper.PartnerMapper;
import com.rider.rider.rides.dto.normals.RideLocationNormal;
import com.rider.rider.rides.dto.normals.RideNormal;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.rides.entity.RideLocation;
import com.rider.rider.rides.enums.RideLocationType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RideMapper {

    public static RideNormal toNormal(Ride ride) {
        if (ride == null) return null;

        return new RideNormal(
                ride.getRideId(),
                null, // If needed: UserMapper.toDto(ride.getUser())
                PartnerMapper.toNormal(ride.getPartner()),
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
                mapToRideLocationNormal(ride.getLocations().stream()
                        .filter(loc -> loc.getLocationType() == RideLocationType.PICKUP)
                        .findFirst().orElse(null)),
                mapToRideLocationNormal(ride.getLocations().stream()
                        .filter(loc -> loc.getLocationType() == RideLocationType.DROP)
                        .findFirst()
                        .orElse(null)),
                ride.getTracking() != null
                        ? ride.getTracking().stream()
                        .map(RideTrackingMapper::toNormal)
                        .collect(Collectors.toList())
                        : null,
                RidePaymentMapper.toNormal(ride.getRidePayment()),
                ride.getRideStatus(),
                ride.getEstimatedDuration(),
                ride.getActualDuration()
        );
    }

    public static Ride toEntity(RideNormal dto) {
        if (dto == null) return null;

        Ride ride = new Ride();
        ride.setRideId(dto.getRideId());
        // ride.setUser(UserMapper.toEntity(dto.getUser())); // If needed
        ride.setPartner(PartnerMapper.toEntity(dto.getPartner()));
        ride.setCreatedTime(dto.getCreatedTime());
        ride.setUpdatedTime(dto.getUpdatedTime());
        ride.setStartTime(dto.getStartTime());
        ride.setEndTime(dto.getEndTime());
        ride.setRequestedTime(dto.getRequestedTime());
        ride.setAcceptedTime(dto.getAcceptedTime());
        ride.setStatus(dto.getStatus());
        ride.setRideType(dto.getRideType());
        ride.setDropAddress(dto.getDropAddress());
        ride.setPickupAddress(dto.getPickupAddress());
        List<RideLocation> rideLocationList = new ArrayList<>();
        rideLocationList.add(RideLocationMapper.toEntity(dto.getPickupLocation(), ride));
        rideLocationList.add(RideLocationMapper.toEntity(dto.getDropLocation(), ride));
        ride.setLocations(rideLocationList);
        ride.setTracking(dto.getRideTracking() != null
                ? dto.getRideTracking().stream()
                .map(RideTrackingMapper::toEntity)
                .collect(Collectors.toList())
                : null);
        ride.setRidePayment(RidePaymentMapper.toEntity(dto.getRidePayment()));
        ride.setRideStatus(dto.getRideStatus());
        ride.setEstimatedDuration(dto.getEstimatedDuration());
        ride.setActualDuration(dto.getActualDuration());

        return ride;
    }

    private static RideLocationNormal mapToRideLocationNormal(RideLocation location) {
        RideLocationNormal rideLocationNormal = new RideLocationNormal();
        rideLocationNormal.setLatitude(location.getLatitude());
        rideLocationNormal.setLongitude(location.getLongitude());
        return rideLocationNormal;
    }

}
