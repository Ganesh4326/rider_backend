package com.rider.rider.partners.utils.mapper;

import com.rider.rider.partners.dto.normal.PartnerVehicleModelNormal;
import com.rider.rider.partners.entity.PartnerVehicleModel;

import java.util.UUID;

public class PartnerVehicleModelMapper {

    public static PartnerVehicleModelNormal toNormal(PartnerVehicleModel entity) {
        if (entity == null) {
            return null;
        }

        PartnerVehicleModelNormal dto = new PartnerVehicleModelNormal();
        dto.setPartnerVehicleModelId(entity.getId().toString());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setModelName(entity.getModelName());
        dto.setModelYear(entity.getModelYear());
        dto.setCompany(entity.getCompany());

        if (entity.getPartnerVehicle() != null) {
            dto.setPartnerVehicleId(entity.getPartnerVehicle().getId().toString());
        }

        return dto;
    }

    public static PartnerVehicleModel toEntity(PartnerVehicleModelNormal dto) {
        if (dto == null) {
            return null;
        }

        PartnerVehicleModel entity = new PartnerVehicleModel();
        entity.setId(UUID.fromString(dto.getPartnerVehicleId()));
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setModelName(dto.getModelName());
        entity.setModelYear(dto.getModelYear());
        entity.setCompany(dto.getCompany());
        return entity;
    }
}
