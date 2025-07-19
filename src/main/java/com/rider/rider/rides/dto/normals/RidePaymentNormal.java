package com.rider.rider.rides.dto.normals;

import com.rider.rider.rides.enums.RidePaymentMode;
import com.rider.rider.rides.enums.RidePaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class RidePaymentNormal {
    private UUID ridePaymentId;
    private UUID rideId;
    private BigDecimal estimatedFare;
    private BigDecimal actualFare;
    private RidePaymentMode ridePaymentMode;
    private RidePaymentStatus ridePaymentStatus;
    private LocalDateTime paidAt;

    public UUID getRidePaymentId() {
        return ridePaymentId;
    }

    public void setRidePaymentId(UUID ridePaymentId) {
        this.ridePaymentId = ridePaymentId;
    }

    public UUID getRideId() {
        return rideId;
    }

    public void setRideId(UUID rideId) {
        this.rideId = rideId;
    }

    public BigDecimal getEstimatedFare() {
        return estimatedFare;
    }

    public void setEstimatedFare(BigDecimal estimatedFare) {
        this.estimatedFare = estimatedFare;
    }

    public BigDecimal getActualFare() {
        return actualFare;
    }

    public void setActualFare(BigDecimal actualFare) {
        this.actualFare = actualFare;
    }

    public RidePaymentMode getRidePaymentMode() {
        return ridePaymentMode;
    }

    public void setRidePaymentMode(RidePaymentMode ridePaymentMode) {
        this.ridePaymentMode = ridePaymentMode;
    }

    public RidePaymentStatus getRidePaymentStatus() {
        return ridePaymentStatus;
    }

    public void setRidePaymentStatus(RidePaymentStatus ridePaymentStatus) {
        this.ridePaymentStatus = ridePaymentStatus;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(LocalDateTime paidAt) {
        this.paidAt = paidAt;
    }

    public RidePaymentNormal() {
    }

    public RidePaymentNormal(UUID ridePaymentId, UUID rideId, BigDecimal estimatedFare, BigDecimal actualFare,
                             RidePaymentMode ridePaymentMode, RidePaymentStatus ridePaymentStatus, LocalDateTime paidAt) {
        this.ridePaymentId = ridePaymentId;
        this.rideId = rideId;
        this.estimatedFare = estimatedFare;
        this.actualFare = actualFare;
        this.ridePaymentMode = ridePaymentMode;
        this.ridePaymentStatus = ridePaymentStatus;
        this.paidAt = paidAt;
    }

}
