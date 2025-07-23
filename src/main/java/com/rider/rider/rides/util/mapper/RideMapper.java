package com.rider.rider.rides.util.mapper;

import com.rider.rider.partners.utils.mapper.PartnerMapper;
import com.rider.rider.ratings.utils.mapper.RatingMapper;
import com.rider.rider.rides.dto.normals.RideNormal;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.users.utils.mapper.UserMapper;

import java.util.UUID;
import java.util.stream.Collectors;

public class RideMapper {

    public static RideNormal toNormal(Ride ride) {
        if (ride == null) return null;

        RideNormal normal = new RideNormal();
        normal.setRideId(ride.getId().toString());
        normal.setCreatedAt(ride.getCreatedAt());
        normal.setUpdatedAt(ride.getUpdatedAt());
        normal.setUser(UserMapper.toNormal(ride.getUser()));
        normal.setPartner(PartnerMapper.toNormal(ride.getPartner()));
        normal.setRideLocationInfo(RideLocationInfoMapper.toNormal(ride.getRideLocationInfo()));
        normal.setRideTimingInfo(RideTimingInfoMapper.toNormal(ride.getRideTimingInfo()));
        normal.setRidePaymentInfo(RidePaymentInfoMapper.toNormal(ride.getRidePaymentInfo()));

        if (ride.getTrackings() != null) {
            normal.setRideTracking(
                    ride.getTrackings()
                            .stream()
                            .map(RideTrackingMapper::toNormal)
                            .collect(Collectors.toList())
            );
        }

        if (ride.getRideRequest() != null && ride.getRideRequest().getId() != null) {
            normal.setRideRequestId(ride.getRideRequest().getId().toString());
        } else {
            normal.setRideRequestId(null);
        }
//        normal.setRating(RatingMapper.toNormal(ride.getRating()));
        normal.setRideStatus(ride.getRideStatus());
        normal.setRideType(ride.getRideType());

        return normal;
    }

    public static Ride toEntity(RideNormal normal) {
        if (normal == null) return null;

        Ride ride = new Ride();
        if (normal.getRideId() != null) {
            ride.setId(UUID.fromString(normal.getRideId()));
        }

        ride.setCreatedAt(normal.getCreatedAt());
        ride.setUpdatedAt(normal.getUpdatedAt());

        ride.setUser(UserMapper.toEntity(normal.getUser()));
        ride.setPartner(PartnerMapper.toEntity(normal.getPartner()));
        ride.setRideLocationInfo(RideLocationInfoMapper.toEntity(normal.getRideLocationInfo()));
        ride.setRideTimingInfo(RideTimingInfoMapper.toEntity(normal.getRideTimingInfo()));
        ride.setRidePaymentInfo(RidePaymentInfoMapper.toEntity(normal.getRidePaymentInfo()));

        if (normal.getRideTracking() != null) {
            ride.setTrackings(
                    normal.getRideTracking()
                            .stream()
                            .map(RideTrackingMapper::toEntity)
                            .collect(Collectors.toList())
            );
        }

//        ride.setRating(RatingMapper.toEntity(normal.getRating()));
//        ride.setRideRequest(normal.getRideRequestId());
        ride.setRideStatus(normal.getRideStatus());
        ride.setRideType(normal.getRideType());

        return ride;
    }
}
