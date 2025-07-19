package com.rider.rider.partners.dto.normal;

import java.time.LocalDateTime;
import java.util.UUID;

public class PartnerLocationNormal {
    private UUID partnerLocationId;
    private Double latitude;
    private Double longitude;
    private String partnerId;
    private LocalDateTime locationUpdatedAt;

    public UUID getPartnerLocationId() {
        return partnerLocationId;
    }

    public void setPartnerLocationId(UUID partnerLocationId) {
        this.partnerLocationId = partnerLocationId;
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

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public LocalDateTime getLocationUpdatedAt() {
        return locationUpdatedAt;
    }

    public void setLocationUpdatedAt(LocalDateTime locationUpdatedAt) {
        this.locationUpdatedAt = locationUpdatedAt;
    }

    public PartnerLocationNormal(){}

    public PartnerLocationNormal(UUID partnerLocationId, Double latitude, Double longitude, String partnerId, LocalDateTime locationUpdatedAt) {
        this.partnerLocationId = partnerLocationId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.partnerId = partnerId;
        this.locationUpdatedAt = locationUpdatedAt;
    }
}
