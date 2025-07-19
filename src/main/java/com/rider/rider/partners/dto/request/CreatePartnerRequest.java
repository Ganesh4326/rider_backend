package com.rider.rider.partners.dto.request;

import com.rider.rider.partners.dto.normal.PartnerLocationNormal;

import java.util.UUID;

public class CreatePartnerRequest {
    private UUID userId;
    private Double partnerLocationLatitude;
    private Double partnerLocationLongitude;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public Double getPartnerLocationLatitude() {
        return partnerLocationLatitude;
    }

    public void setPartnerLocationLatitude(Double partnerLocationLatitude) {
        this.partnerLocationLatitude = partnerLocationLatitude;
    }

    public Double getPartnerLocationLongitude() {
        return partnerLocationLongitude;
    }

    public void setPartnerLocationLongitude(Double partnerLocationLongitude) {
        this.partnerLocationLongitude = partnerLocationLongitude;
    }
}
