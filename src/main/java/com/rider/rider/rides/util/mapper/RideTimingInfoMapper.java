package com.rider.rider.rides.util.mapper;

import com.rider.rider.rides.dto.normals.RideTimingInfoNormal;
import com.rider.rider.rides.entity.RideTimingInfo;

import java.util.UUID;

public class RideTimingInfoMapper {

    public static RideTimingInfoNormal toNormal(RideTimingInfo entity) {
        if (entity == null) return null;

        RideTimingInfoNormal dto = new RideTimingInfoNormal();
        dto.setRideTimingInfoId(entity.getId().toString());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setRideId(entity.getRide() != null ? entity.getRide().getId().toString() : null);
        dto.setStartTime(entity.getStartTime());
        dto.setEndTime(entity.getEndTime());
        dto.setEstimatedWaitingTime(entity.getEstimatedWaitingTime());
        dto.setActualWaitingTime(entity.getActualWaitingTime());
        dto.setEstimatedReachTime(entity.getEstimatedReachTime());
        dto.setActualReachTime(entity.getActualReachTime());
        dto.setPartnerAcceptedTime(entity.getPartnerAcceptedTime());
        dto.setEstimatedPartnerArrivalTime(entity.getEstimatedPartnerArrivalTime());
        dto.setActualPartnerArrivalTime(entity.getActualPartnerArrivalTime());
        dto.setEstimatedTotalDuration(entity.getEstimatedTotalDuration());
        dto.setActualTotalDuration(entity.getActualTotalDuration());

        return dto;
    }

    public static RideTimingInfo toEntity(RideTimingInfoNormal dto) {
        if (dto == null) return null;

        RideTimingInfo entity = new RideTimingInfo();

        entity.setId(UUID.fromString(dto.getRideTimingInfoId()));
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setStartTime(dto.getStartTime());
        entity.setEndTime(dto.getEndTime());
        entity.setEstimatedWaitingTime(dto.getEstimatedWaitingTime());
        entity.setActualWaitingTime(dto.getActualWaitingTime());
        entity.setEstimatedReachTime(dto.getEstimatedReachTime());
        entity.setActualReachTime(dto.getActualReachTime());
        entity.setPartnerAcceptedTime(dto.getPartnerAcceptedTime());
        entity.setEstimatedPartnerArrivalTime(dto.getEstimatedPartnerArrivalTime());
        entity.setActualPartnerArrivalTime(dto.getActualPartnerArrivalTime());
        entity.setEstimatedTotalDuration(dto.getEstimatedTotalDuration());
        entity.setActualTotalDuration(dto.getActualTotalDuration());

        return entity;
    }
}
