package com.rider.rider.rides.entity;

import com.rider.rider.rides.enums.RidePaymentMode;
import com.rider.rider.rides.enums.RidePaymentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ride_payments")
public class RidePayment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ride_payment_id", nullable = false, updatable = false, columnDefinition = "UUID")
    private UUID ridePaymentId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ride_id", nullable = false)
    private Ride ride;

    @Column(name = "estimated_fare", nullable = false)
    private BigDecimal estimatedFare;

    @Column(name = "actual_fare")
    private BigDecimal actualFare;

    @Enumerated
    @Column(name = "ride_payment_mode")
    private RidePaymentMode ridePaymentMode;

    @Column(name = "ride_payment_status", nullable = false)
    private RidePaymentStatus ridePaymentStatus = RidePaymentStatus.PENDING;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    public UUID getRidePaymentId() {
        return ridePaymentId;
    }

    public void setRidePaymentId(UUID ridePaymentId) {
        this.ridePaymentId = ridePaymentId;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
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
}
