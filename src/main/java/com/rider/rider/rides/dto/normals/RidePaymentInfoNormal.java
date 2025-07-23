package com.rider.rider.rides.dto.normals;

import com.rider.rider.payments.dto.normals.PaymentNormal;
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
public class RidePaymentInfoNormal {
    private String ridePaymentInfoId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String rideId;
    private PaymentNormal payment;
    private BigDecimal additionalFareByUser;
    private BigDecimal estimatedFare;
    private BigDecimal actualFare;
}
