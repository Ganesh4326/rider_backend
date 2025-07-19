package com.rider.rider.rides.dto.requests;

import com.rider.rider.rides.enums.RideStatus;

import java.util.UUID;

public class CreateRideEventRequest {
    private UUID rideId;
    private RideStatus rideEventType;

    public RideStatus getRideEventType() {
        return rideEventType;
    }

    public void setRideEventType(RideStatus rideEventType) {
        this.rideEventType = rideEventType;
    }

    public UUID getRideId() {
        return rideId;
    }

    public void setRideId(UUID rideId) {
        this.rideId = rideId;
    }

}
