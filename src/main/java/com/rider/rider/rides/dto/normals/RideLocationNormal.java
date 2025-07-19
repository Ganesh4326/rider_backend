package com.rider.rider.rides.dto.normals;

import com.rider.rider.rides.enums.RideLocationType;

import java.util.UUID;

public class RideLocationNormal {
    private String rideLocationId;
    private Double latitude;
    private Double longitude;
    private String rideId;
    private RideLocationType rideLocationType;

    public String getRideLocationId() {
        return rideLocationId;
    }

    public void setRideLocationId(String rideLocationId) {
        this.rideLocationId = rideLocationId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public RideLocationType getRideLocationType() {
        return rideLocationType;
    }

    public void setRideLocationType(RideLocationType rideLocationType) {
        this.rideLocationType = rideLocationType;
    }
}
