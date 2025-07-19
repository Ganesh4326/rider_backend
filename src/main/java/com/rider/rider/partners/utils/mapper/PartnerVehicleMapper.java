package com.rider.rider.partners.utils.mapper;

import com.rider.rider.partners.dto.normal.PartnerVehicleNormal;
import com.rider.rider.partners.entity.PartnerVehicle;

public class PartnerVehicleMapper {

    public static PartnerVehicleNormal toNormal(PartnerVehicle entity) {
        if (entity == null) return null;

        PartnerVehicleNormal dto = new PartnerVehicleNormal();
        dto.setPartnerVehicleId(entity.getPartnerVehicleId());
        dto.setPartnerVehicleType(entity.getPartnerVehicleType());
        dto.setPartnerVehicleCompany(entity.getPartnerVehicleCompany());
        dto.setPartnerVehicleModelName(entity.getPartnerVehicleModelName());
        dto.setPartnerVehicleModelYear(entity.getPartnerVehicleModelYear());
        dto.setPartnerVehicleRegistrationNumber(entity.getPartnerVehicleRegistrationNumber());
        return dto;
    }

    public static PartnerVehicle toEntity(PartnerVehicleNormal dto) {
        if (dto == null) return null;

        PartnerVehicle entity = new PartnerVehicle();
        entity.setPartnerVehicleId(dto.getPartnerVehicleId());
        entity.setPartnerVehicleType(dto.getPartnerVehicleType());
        entity.setPartnerVehicleCompany(dto.getPartnerVehicleCompany());
        entity.setPartnerVehicleModelName(dto.getPartnerVehicleModelName());
        entity.setPartnerVehicleModelYear(dto.getPartnerVehicleModelYear());
        entity.setPartnerVehicleRegistrationNumber(dto.getPartnerVehicleRegistrationNumber());
        return entity;
    }
}
