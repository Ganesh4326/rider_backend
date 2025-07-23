package com.rider.rider.partners.utils.mapper;

import com.rider.rider.locations.mapper.LocationMapper;
import com.rider.rider.partners.dto.normal.PartnerNormal;
import com.rider.rider.partners.entity.Partner;
import com.rider.rider.users.utils.mapper.UserMapper;

import java.util.UUID;
import java.util.stream.Collectors;

public class PartnerMapper {
    public static Partner toEntity(PartnerNormal dto) {
        if (dto == null) return null;

        Partner partner = new Partner();
        partner.setId(UUID.fromString(dto.getPartnerId()));
        partner.setCreatedAt(dto.getCreatedAt());
        partner.setUpdatedAt(dto.getUpdatedAt());
        partner.setPartnerVehicles(dto.getPartnerVehicles().stream()
                .map(PartnerVehicleMapper::toEntity)
                .collect(Collectors.toList()));
        partner.setCurrentLocation(LocationMapper.toEntity(dto.getCurrentLocation()));
        partner.setUser(UserMapper.toEntity(dto.getUser()));
        partner.setRating(dto.getRating());
        partner.setTotalRidesCompleted(dto.getTotalRidesCompleted());
        partner.setTotalRidesRejected(dto.getTotalRidesRejected());
        partner.setTotalAmountEarned(dto.getTotalAmountEarned());
        partner.setVerificationStatus(dto.getVerificationStatus());
        partner.setPartnerStatus(dto.getPartnerStatus());
        partner.setPartnerCurrentStatus(dto.getPartnerCurrentStatus());
        return partner;
    }

    public static PartnerNormal toNormal(Partner entity) {
        if (entity == null) return null;

        PartnerNormal dto = new PartnerNormal();
        dto.setPartnerId(entity.getId().toString());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setPartnerVehicles(entity.getPartnerVehicles().stream()
                .map(PartnerVehicleMapper::toNormal)
                .collect(Collectors.toList()));
        dto.setCurrentLocation(LocationMapper.toNormal(entity.getCurrentLocation()));
        dto.setUser(UserMapper.toNormal(entity.getUser()));
        dto.setCurrentRideId(entity.getCurrentRide() != null ? entity.getCurrentRide().getId().toString() : null);
        dto.setRating(entity.getRating());
        dto.setTotalRidesCompleted(entity.getTotalRidesCompleted());
        dto.setTotalRidesRejected(entity.getTotalRidesRejected());
        dto.setTotalAmountEarned(entity.getTotalAmountEarned());
        dto.setVerificationStatus(entity.getVerificationStatus());
        dto.setPartnerStatus(entity.getPartnerStatus());
        dto.setPartnerCurrentStatus(entity.getPartnerCurrentStatus());
        return dto;
    }
}
