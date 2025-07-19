package com.rider.rider.rides.util.mapper;

import com.rider.rider.rides.dto.normals.RideTrackingNormal;
import com.rider.rider.rides.entity.RideTracking;

public class RideTrackingMapper {

    public static RideTrackingNormal toNormal(RideTracking entity) {
        if (entity == null) return null;

        RideTrackingNormal normal = new RideTrackingNormal();
        normal.setRideTrackingId(entity.getRideTrackingId());
        normal.setCreatedTime(entity.getCreatedTime());
        normal.setLatitude(entity.getLatitude());
        normal.setLongitude(entity.getLongitude());
        return normal;
    }

    public static RideTracking toEntity(RideTrackingNormal normal) {
        if (normal == null) return null;

        RideTracking entity = new RideTracking();
        entity.setRideTrackingId(normal.getRideTrackingId());
        entity.setCreatedTime(normal.getCreatedTime());
        entity.setLatitude(normal.getLatitude());
        entity.setLongitude(normal.getLongitude());
        return entity;
    }
}
