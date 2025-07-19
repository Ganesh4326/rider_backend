package com.rider.rider.rides.dto.requests;

import java.util.UUID;

public class CreateRideRequest {
    private UUID userId;
    private Double pickupLatitude;
    private Double pickupLongitude;
    private Double dropLatitude;
    private Double dropLongitude;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Double getPickupLatitude() {
        return pickupLatitude;
    }

    public void setPickupLatitude(Double pickupLatitude) {
        this.pickupLatitude = pickupLatitude;
    }

    public Double getPickupLongitude() {
        return pickupLongitude;
    }

    public void setPickupLongitude(Double pickupLongitude) {
        this.pickupLongitude = pickupLongitude;
    }

    public Double getDropLatitude() {
        return dropLatitude;
    }

    public void setDropLatitude(Double dropLatitude) {
        this.dropLatitude = dropLatitude;
    }

    public Double getDropLongitude() {
        return dropLongitude;
    }

    public void setDropLongitude(Double dropLongitude) {
        this.dropLongitude = dropLongitude;
    }
}
