package com.rider.rider.partners.dto.request;

import java.util.UUID;

public class AttachPartnerToRideRequest {
    private UUID rideId;
    private UUID partnerId;

    public UUID getRideId() {
        return rideId;
    }

    public void setRideId(UUID rideId) {
        this.rideId = rideId;
    }

    public UUID getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(UUID partnerId) {
        this.partnerId = partnerId;
    }
}
