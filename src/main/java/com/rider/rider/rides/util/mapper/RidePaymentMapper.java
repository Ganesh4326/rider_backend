package com.rider.rider.rides.util.mapper;

import com.rider.rider.rides.dto.normals.RidePaymentNormal;
import com.rider.rider.rides.entity.RidePayment;

public class RidePaymentMapper {

    public static RidePaymentNormal toNormal(RidePayment entity) {
        if (entity == null) return null;

        RidePaymentNormal normal = new RidePaymentNormal();
        normal.setRidePaymentId(entity.getRidePaymentId());
        normal.setEstimatedFare(entity.getEstimatedFare());
        normal.setActualFare(entity.getActualFare());
        normal.setRidePaymentMode(entity.getRidePaymentMode());
        normal.setRidePaymentStatus(entity.getRidePaymentStatus());
        normal.setPaidAt(entity.getPaidAt());
        return normal;
    }

    public static RidePayment toEntity(RidePaymentNormal normal) {
        if (normal == null) return null;

        RidePayment entity = new RidePayment();
        entity.setRidePaymentId(normal.getRidePaymentId());
        entity.setEstimatedFare(normal.getEstimatedFare());
        entity.setActualFare(normal.getActualFare());
        entity.setRidePaymentMode(normal.getRidePaymentMode());
        entity.setRidePaymentStatus(normal.getRidePaymentStatus());
        entity.setPaidAt(normal.getPaidAt());
        return entity;
    }
}
