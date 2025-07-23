package com.rider.rider.rides.util.mapper;

import com.rider.rider.rides.dto.normals.RideTrackingNormal;
import com.rider.rider.rides.entity.RideTracking;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RideTrackingMapper {

    public static RideTrackingNormal toNormal(RideTracking entity) {
        if (entity == null) return null;

        RideTrackingNormal normal = new RideTrackingNormal();
        normal.setRideTrackingId(entity.getId().toString());
        normal.setCreatedAt(entity.getCreatedAt());
        normal.setUpdatedAt(entity.getUpdatedAt());
        normal.setLatitude(entity.getLatitude());
        normal.setLongitude(entity.getLongitude());
        return normal;
    }

    public static RideTracking toEntity(RideTrackingNormal normal) {
        if (normal == null) return null;

        RideTracking entity = new RideTracking();
        entity.setId(UUID.fromString(normal.getRideTrackingId()));
        entity.setCreatedAt(normal.getCreatedAt());
        entity.setUpdatedAt(normal.getUpdatedAt());
        entity.setLatitude(normal.getLatitude());
        entity.setLongitude(normal.getLongitude());
        return entity;
    }

    public static List<RideTrackingNormal> toNormalList(List<RideTracking> entityList) {
        if (entityList == null) return null;
        return entityList.stream()
                .map(RideTrackingMapper::toNormal)
                .collect(Collectors.toList());
    }

    public static List<RideTracking> toEntityList(List<RideTrackingNormal> normalList) {
        if (normalList == null) return null;
        return normalList.stream()
                .map(RideTrackingMapper::toEntity)
                .collect(Collectors.toList());
    }
}
