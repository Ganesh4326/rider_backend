package com.rider.rider.rides.dto.normals;

import java.time.LocalDateTime;
import java.util.UUID;

public class RideTrackingNormal {
    private UUID rideTrackingId;
    private LocalDateTime createdTime;
    private Double latitude;
    private Double longitude;

    public UUID getRideTrackingId() {
        return rideTrackingId;
    }

    public void setRideTrackingId(UUID rideTrackingId) {
        this.rideTrackingId = rideTrackingId;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
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

    public RideTrackingNormal(){}

    public RideTrackingNormal(UUID rideTrackingId, LocalDateTime createdTime, Double latitude, Double longitude) {
        this.rideTrackingId = rideTrackingId;
        this.createdTime = createdTime;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
