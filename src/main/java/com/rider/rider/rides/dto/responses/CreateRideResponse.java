package com.rider.rider.rides.dto.responses;

import java.util.UUID;

public class CreateRideResponse {
    private UUID rideId;

    public CreateRideResponse(UUID rideId) {
        this.rideId = rideId;
    }

    public UUID getRideId() {
        return rideId;
    }

    public void setRideId(UUID rideId) {
        this.rideId = rideId;
    }
}
