package com.rider.rider.rides.util.mapper;

import com.rider.rider.payments.utils.mapper.PaymentMapper;
import com.rider.rider.rides.dto.normals.RidePaymentInfoNormal;
import com.rider.rider.rides.entity.RidePaymentInfo;

import java.util.UUID;

public class RidePaymentInfoMapper {

    public static RidePaymentInfoNormal toNormal(RidePaymentInfo ridePaymentInfo) {
        if (ridePaymentInfo == null) return null;

        RidePaymentInfoNormal normal = new RidePaymentInfoNormal();
        normal.setRidePaymentInfoId(ridePaymentInfo.getId().toString());
        normal.setCreatedAt(ridePaymentInfo.getCreatedAt());
        normal.setUpdatedAt(ridePaymentInfo.getUpdatedAt());
        normal.setRideId(ridePaymentInfo.getRide() != null ? ridePaymentInfo.getRide().getId().toString() : null);
        normal.setPayment(PaymentMapper.toNormal(ridePaymentInfo.getPayment()));
        normal.setAdditionalFareByUser(ridePaymentInfo.getAdditionalFareByUser());
        normal.setEstimatedFare(ridePaymentInfo.getEstimatedFare());
        normal.setActualFare(ridePaymentInfo.getActualFare());

        return normal;
    }

    public static RidePaymentInfo toEntity(RidePaymentInfoNormal normal) {
        if (normal == null) return null;

        RidePaymentInfo entity = new RidePaymentInfo();

        entity.setId(UUID.fromString(normal.getRidePaymentInfoId()));
        entity.setCreatedAt(normal.getCreatedAt());
        entity.setUpdatedAt(normal.getUpdatedAt());
        entity.setPayment(PaymentMapper.toEntity(normal.getPayment()));
        entity.setAdditionalFareByUser(normal.getAdditionalFareByUser());
        entity.setEstimatedFare(normal.getEstimatedFare());
        entity.setActualFare(normal.getActualFare());

        return entity;
    }
}
