package com.rider.rider.partners.utils.mapper;

import com.rider.rider.partners.dto.normal.PartnerLocationNormal;
import com.rider.rider.partners.entity.PartnerLocation;

public class PartnerLocationMapper {

    public static PartnerLocationNormal toNormal(PartnerLocation entity) {
        if (entity == null) return null;

        PartnerLocationNormal normal = new PartnerLocationNormal();
        normal.setPartnerLocationId(entity.getPartnerLocationId());
        normal.setLatitude(entity.getLatitude());
        normal.setLongitude(entity.getLongitude());
        normal.setLocationUpdatedAt(entity.getLocationUpdatedAt());
        return normal;
    }

    public static PartnerLocation toEntity(PartnerLocationNormal normal) {
        if (normal == null) return null;

        PartnerLocation entity = new PartnerLocation();
        entity.setPartnerLocationId(normal.getPartnerLocationId());
        entity.setLatitude(normal.getLatitude());
        entity.setLongitude(normal.getLongitude());
        entity.setLocationUpdatedAt(normal.getLocationUpdatedAt());
        return entity;
    }
}
