package com.rider.rider.rides.dto.requests;

import com.rider.rider.rides.enums.RideStatus;

import java.util.UUID;

public class UpdateRideStatusRequest {
    public UUID getRideId() {
        return rideId;
    }

    public void setRideId(UUID rideId) {
        this.rideId = rideId;
    }

    private UUID rideId;
    private RideStatus rideStatus;

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }
}
