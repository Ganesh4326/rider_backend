package com.rider.rider.payments.entity;

import com.rider.rider.core.entity.BaseEntity;
import com.rider.rider.partners.entity.Partner;
import com.rider.rider.payments.enums.PaymentMode;
import com.rider.rider.payments.enums.PaymentStatus;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.rides.entity.RidePaymentInfo;
import com.rider.rider.users.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "payment_id", nullable = false, updatable = false, columnDefinition = "UUID"))
public class Payment extends BaseEntity {
    @OneToOne(mappedBy = "payment")
    private RidePaymentInfo ridePaymentInfo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id")
    private Partner partner;

    @Column(name = "paid_at")
    private LocalDateTime paidAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "transaction_id")
    private String transactionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_mode")
    private PaymentMode paymentMode;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_status", nullable = false)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
}
