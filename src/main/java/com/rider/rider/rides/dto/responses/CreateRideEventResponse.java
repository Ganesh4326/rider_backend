package com.rider.rider.rides.dto.responses;

import java.util.UUID;

public class CreateRideEventResponse {
    private UUID rideEventId;

    public UUID getRideEventId() {
        return rideEventId;
    }

    public void setRideEventId(UUID rideEventId) {
        this.rideEventId = rideEventId;
    }

    public CreateRideEventResponse(UUID rideEventId) {
        this.rideEventId = rideEventId;
    }
}
