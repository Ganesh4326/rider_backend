package com.rider.rider.rides.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRideRequestRequest {
    private String rideId;
    private Double rideLatitude;
    private Double rideLongitude;
}
