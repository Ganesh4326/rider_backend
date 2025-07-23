package com.rider.rider.rides.entity;

import com.rider.rider.core.entity.BaseEntity;
import com.rider.rider.payments.entity.Payment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "ride_payment_infos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "ride_payment_info_id", nullable = false, updatable = false, columnDefinition = "UUID"))
public class RidePaymentInfo extends BaseEntity {
    @OneToOne(mappedBy = "ridePaymentInfo")
    private Ride ride;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @Column(name = "additional_fare_by_user")
    private BigDecimal additionalFareByUser;

    @Column(name = "estimated_fare", nullable = false)
    private BigDecimal estimatedFare;

    @Column(name = "actual_fare")
    private BigDecimal actualFare;
}
