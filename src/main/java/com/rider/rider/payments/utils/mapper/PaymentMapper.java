package com.rider.rider.payments.utils.mapper;

import com.rider.rider.payments.dto.normals.PaymentNormal;
import com.rider.rider.payments.entity.Payment;

import java.util.UUID;

public class PaymentMapper {

    public static PaymentNormal toNormal(Payment payment) {
        if (payment == null) return null;

        PaymentNormal dto = new PaymentNormal();
        dto.setPaymentId(payment.getId().toString());
        if(payment.getRidePaymentInfo() != null){
            dto.setRidePaymentId(payment.getRidePaymentInfo().getId().toString());
        } else {
            dto.setRidePaymentId(null);
        }
        dto.setPaidAt(payment.getPaidAt());
        dto.setCurrency(payment.getCurrency());
        dto.setTransactionId(payment.getTransactionId());
        dto.setPaymentMode(payment.getPaymentMode());
        dto.setPaymentStatus(payment.getPaymentStatus());
        return dto;
    }

    public static Payment toEntity(PaymentNormal dto) {
        if (dto == null) return null;

        Payment payment = new Payment();
        payment.setId(UUID.fromString(dto.getPaymentId()));
//        payment.setRidePaymentInfo(dto.getRidePaymentInfo());
        payment.setPaidAt(dto.getPaidAt());
        payment.setCurrency(dto.getCurrency());
        payment.setTransactionId(dto.getTransactionId());
        payment.setPaymentMode(dto.getPaymentMode());
        payment.setPaymentStatus(dto.getPaymentStatus());
        return payment;
    }
}
