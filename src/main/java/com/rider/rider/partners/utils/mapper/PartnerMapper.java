package com.rider.rider.partners.utils.mapper;

import com.rider.rider.partners.dto.normal.PartnerNormal;
import com.rider.rider.partners.entity.Partner;
import com.rider.rider.rides.util.mapper.RideMapper;

import java.util.UUID;

public class PartnerMapper {

    public static PartnerNormal toNormal(Partner partner) {
        if (partner == null) return null;

        PartnerNormal normal = new PartnerNormal();
        normal.setPartnerId(partner.getPartnerId().toString());
        normal.setPartnerCurrentStatus(partner.getPartnerCurrentStatus());
        normal.setPartnerVehicleNormal(PartnerVehicleMapper.toNormal(partner.getPartnerVehicle()));
        normal.setPartnerLocationNormal(PartnerLocationMapper.toNormal(partner.getPartnerLocation()));
//        normal.setUserNormal(UserMapper.toNormal(partner.getUser()));
        normal.setCurrentRideNormal(RideMapper.toNormal(partner.getCurrentRide()));
        normal.setRating(partner.getRating());
        normal.setTotalRidesCompleted(partner.getTotalRidesCompleted());
        normal.setVerified(partner.getVerified());
        normal.setPartnerStatus(partner.getPartnerStatus());

        return normal;
    }

    public static Partner toEntity(PartnerNormal normal) {
        if (normal == null) return null;

        Partner partner = new Partner();
        partner.setPartnerId(UUID.fromString(normal.getPartnerId()));
        partner.setPartnerCurrentStatus(normal.getPartnerCurrentStatus());
        partner.setPartnerVehicle(PartnerVehicleMapper.toEntity(normal.getPartnerVehicleNormal()));
        partner.setPartnerLocation(PartnerLocationMapper.toEntity(normal.getPartnerLocationNormal()));
//        partner.setUser(UserMapper.toEntity(normal.getUserNormal()));
        partner.setCurrentRide(RideMapper.toEntity(normal.getCurrentRideNormal()));
        partner.setRating(normal.getRating());
        partner.setTotalRidesCompleted(normal.getTotalRidesCompleted());
        partner.setVerified(normal.getVerified());
        partner.setPartnerStatus(normal.getPartnerStatus());

        return partner;
    }
}
