package com.rider.rider.partners.utils.mapper;

import com.rider.rider.partners.dto.normal.PartnerVehicleNormal;
import com.rider.rider.partners.entity.PartnerVehicle;

import java.util.UUID;

public class PartnerVehicleMapper {

    public static PartnerVehicleNormal toNormal(PartnerVehicle entity) {
        if (entity == null) return null;

        return new PartnerVehicleNormal() {{
            setPartnerVehicleId(entity.getId().toString());
            setCreatedAt(entity.getCreatedAt());
            setUpdatedAt(entity.getUpdatedAt());
            setPartnerId(entity.getPartner().getId().toString());
            setPartnerVehicleModel(PartnerVehicleModelMapper.toNormal(entity.getPartnerVehicleModel()));
            setPartnerVehicleRegistrationNumber(entity.getPartnerVehicleRegistrationNumber());
            setPartnerVehicleType(entity.getPartnerVehicleType());
            setPartnerVehicleColor(entity.getColor());
        }};
    }

    public static PartnerVehicle toEntity(PartnerVehicleNormal dto) {
        if (dto == null) return null;

        PartnerVehicle vehicle = new PartnerVehicle();
        if (dto.getPartnerVehicleId() != null)
            vehicle.setId(UUID.fromString(dto.getPartnerVehicleId()));
        vehicle.setCreatedAt(dto.getCreatedAt());
        vehicle.setUpdatedAt(dto.getUpdatedAt());
        vehicle.setPartnerVehicleModel(PartnerVehicleModelMapper.toEntity(dto.getPartnerVehicleModel()));
        vehicle.setPartnerVehicleRegistrationNumber(dto.getPartnerVehicleRegistrationNumber());
        vehicle.setPartnerVehicleType(dto.getPartnerVehicleType());
        vehicle.setColor(dto.getPartnerVehicleColor());
        return vehicle;
    }
}
