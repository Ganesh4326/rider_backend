package com.rider.rider.rides.util.mapper;

import com.rider.rider.rides.dto.normals.RideEventNormal;
import com.rider.rider.rides.entity.RideEvent;

import java.util.UUID;

public class RideEventMapper {

    public static RideEventNormal toNormal(RideEvent entity) {
        RideEventNormal rideEventNormal = new RideEventNormal();
        rideEventNormal.setRideId(entity.getId().toString());
        rideEventNormal.setCreatedAt(entity.getCreatedAt());
        rideEventNormal.setUpdatedAt(entity.getUpdatedAt());
        if (entity.getRideId() != null) {
            rideEventNormal.setRideId(entity.getRideId().toString());
        } else {
            rideEventNormal.setRideId(null);
        }
        rideEventNormal.setMetaData(entity.getMetaData());
        rideEventNormal.setRideStatus(entity.getRideStatus());
        return rideEventNormal;
    }

    public static RideEvent toEntity(RideEventNormal normal) {
        RideEvent rideEvent = new RideEvent();
        rideEvent.setRideId(UUID.fromString(normal.getRideId()));
        rideEvent.setCreatedAt(normal.getCreatedAt());
        rideEvent.setUpdatedAt(normal.getUpdatedAt());
        if (normal.getRideId() != null) {
            rideEvent.setRideId(UUID.fromString(normal.getRideId()));
        } else {
            rideEvent.setRideId(null);
        }
        rideEvent.setMetaData(normal.getMetaData());
        rideEvent.setRideStatus(normal.getRideStatus());
        return rideEvent;
    }
}
