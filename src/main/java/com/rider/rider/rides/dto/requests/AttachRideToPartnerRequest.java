package com.rider.rider.rides.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttachRideToPartnerRequest {
    private String rideId;
    private String partnerId;
    private Double rideLatitude;
    private Double rideLongitude;
}
