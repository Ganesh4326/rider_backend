package com.rider.rider.rides.util.mapper;

import com.rider.rider.partners.utils.mapper.PartnerMapper;
import com.rider.rider.rides.dto.normals.RideRequestNormal;
import com.rider.rider.rides.entity.RideRequest;

import java.util.List;
import java.util.stream.Collectors;

public class RideRequestMapper {

    public static RideRequestNormal toNormal(RideRequest entity) {
        if (entity == null) return null;

        RideRequestNormal dto = new RideRequestNormal();
        dto.setRideRequestId(entity.getId() != null ? entity.getId().toString() : null);
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setRide(RideMapper.toNormal(entity.getRide()));
        dto.setNearbyPartners(entity.getNearbyPartners().stream().map(PartnerMapper::toNormal)
                .collect(Collectors.toList()));
        dto.setAcceptedPartner(PartnerMapper.toNormal(entity.getAcceptedPartner()));
        dto.setRideRequestStatus(entity.getRideRequestStatus());

        return dto;
    }

    public static RideRequest toEntity(RideRequestNormal dto) {
        if (dto == null) return null;

        RideRequest entity = new RideRequest();
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setRide(RideMapper.toEntity(dto.getRide()));
        entity.setNearbyPartners(dto.getNearbyPartners().stream().map(PartnerMapper::toEntity)
                .collect(Collectors.toList()));
        entity.setAcceptedPartner(PartnerMapper.toEntity(dto.getAcceptedPartner()));
        entity.setRideRequestStatus(dto.getRideRequestStatus());

        return entity;
    }

    public static List<RideRequestNormal> toNormalList(List<RideRequest> entities) {
        return entities.stream()
                .map(RideRequestMapper::toNormal)
                .collect(Collectors.toList());
    }

    public static List<RideRequest> toEntityList(List<RideRequestNormal> dtos) {
        return dtos.stream()
                .map(RideRequestMapper::toEntity)
                .collect(Collectors.toList());
    }
}
