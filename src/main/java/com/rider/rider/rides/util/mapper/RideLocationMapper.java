package com.rider.rider.rides.util.mapper;

import com.rider.rider.rides.dto.normals.RideLocationNormal;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.rides.entity.RideLocation;

import java.util.UUID;

public class RideLocationMapper {

    public static RideLocationNormal toNormal(RideLocation entity) {
        if (entity == null) return null;

        RideLocationNormal normal = new RideLocationNormal();
        normal.setRideLocationId(entity.getRideLocationId().toString());
        normal.setRideLocationType(entity.getLocationType());
        normal.setLatitude(entity.getLatitude());
        normal.setLongitude(entity.getLongitude());
        normal.setRideId(entity.getRide().getRideId().toString()); // assuming getRideId() exists

        return normal;
    }

    public static RideLocation toEntity(RideLocationNormal normal, Ride ride) {
        if (normal == null) return null;

        RideLocation entity = new RideLocation();
        entity.setRideLocationId(UUID.fromString(normal.getRideLocationId()));
        entity.setLocationType(normal.getRideLocationType());
        entity.setLatitude(normal.getLatitude());
        entity.setLongitude(normal.getLongitude());
        entity.setRide(ride);

        return entity;
    }
}
