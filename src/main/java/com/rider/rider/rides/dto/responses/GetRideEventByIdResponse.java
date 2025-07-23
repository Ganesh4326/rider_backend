package com.rider.rider.rides.dto.responses;

import com.rider.rider.rides.dto.normals.RideEventNormal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetRideEventByIdResponse {
    private RideEventNormal rideEvent;
}
