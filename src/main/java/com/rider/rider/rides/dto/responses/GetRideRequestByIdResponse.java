package com.rider.rider.rides.dto.responses;

import com.rider.rider.rides.dto.normals.RideRequestNormal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetRideRequestByIdResponse {
    private RideRequestNormal rideRequestNormal;
}
