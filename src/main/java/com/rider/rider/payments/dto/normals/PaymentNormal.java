package com.rider.rider.payments.dto.normals;

import com.rider.rider.partners.dto.normal.PartnerNormal;
import com.rider.rider.payments.enums.PaymentMode;
import com.rider.rider.payments.enums.PaymentStatus;
import com.rider.rider.rides.dto.normals.RideNormal;
import com.rider.rider.rides.entity.RidePaymentInfo;
import com.rider.rider.users.dto.normals.UserNormal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentNormal {
    private String paymentId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String ridePaymentId;
    private UserNormal user;
    private PartnerNormal partner;
    private LocalDateTime paidAt;
    private String transactionId;
    private String currency;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
}
