package com.rider.rider.rides.util.mapper;

import com.rider.rider.locations.mapper.LocationMapper;
import com.rider.rider.rides.dto.normals.RideLocationInfoNormal;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.rides.entity.RideLocationInfo;

import java.util.UUID;

public class RideLocationInfoMapper {

    public static RideLocationInfoNormal toNormal(RideLocationInfo rideLocationInfo) {
        if (rideLocationInfo == null) return null;

        RideLocationInfoNormal normal = new RideLocationInfoNormal();
        normal.setRideLocationInfoId(rideLocationInfo.getId().toString());
        normal.setCreatedAt(rideLocationInfo.getCreatedAt());
        normal.setUpdatedAt(rideLocationInfo.getUpdatedAt());
        normal.setRideId(rideLocationInfo.getRide() != null ? rideLocationInfo.getRide().getId().toString() : null);
        normal.setPickupLocation(LocationMapper.toNormal(rideLocationInfo.getPickupLocation()));
        normal.setDropLocation(LocationMapper.toNormal(rideLocationInfo.getDropLocation()));
        normal.setDestinationDistanceInMeters(rideLocationInfo.getDestinationDistanceInMeters());
        normal.setPartnerDistanceInMeters(rideLocationInfo.getPartnerDistanceInMeters());
        return normal;
    }

    public static RideLocationInfo toEntity(RideLocationInfoNormal normal) {
        if (normal == null) return new RideLocationInfo();

        RideLocationInfo rideLocationInfo = new RideLocationInfo();

        rideLocationInfo.setId(UUID.fromString(normal.getRideLocationInfoId()));
        rideLocationInfo.setCreatedAt(normal.getCreatedAt());
        rideLocationInfo.setUpdatedAt(normal.getUpdatedAt());
        rideLocationInfo.setPickupLocation(LocationMapper.toEntity(normal.getPickupLocation()));
        rideLocationInfo.setDropLocation(LocationMapper.toEntity(normal.getDropLocation()));
        rideLocationInfo.setDestinationDistanceInMeters(normal.getDestinationDistanceInMeters());
        rideLocationInfo.setPartnerDistanceInMeters(normal.getPartnerDistanceInMeters());
        return rideLocationInfo;
    }
}
