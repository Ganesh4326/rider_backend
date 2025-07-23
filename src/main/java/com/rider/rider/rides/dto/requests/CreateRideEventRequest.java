package com.rider.rider.rides.dto.requests;

import com.rider.rider.rides.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateRideEventRequest {
    private String rideId;
    private RideStatus rideEventType;

}
