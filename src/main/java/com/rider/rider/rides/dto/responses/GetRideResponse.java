package com.rider.rider.rides.dto.responses;

import com.rider.rider.rides.dto.normals.RideNormal;

public class GetRideResponse {
    private RideNormal rideNormal;

    public RideNormal getRideNormal() {
        return rideNormal;
    }

    public void setRideNormal(RideNormal rideNormal) {
        this.rideNormal = rideNormal;
    }

    public GetRideResponse(RideNormal rideNormal) {
        this.rideNormal = rideNormal;
    }
}
