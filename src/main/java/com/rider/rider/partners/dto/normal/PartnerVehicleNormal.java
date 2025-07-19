package com.rider.rider.partners.dto.normal;

import com.rider.rider.partners.enums.PartnerVehicleType;

import java.util.UUID;

public class PartnerVehicleNormal {
    private UUID partnerVehicleId;
    private UUID partnerId;
    private PartnerVehicleType partnerVehicleType;
    private String partnerVehicleCompany;
    private String partnerVehicleModelName;
    private String partnerVehicleModelYear;
    private String partnerVehicleRegistrationNumber;

    public UUID getPartnerVehicleId() {
        return partnerVehicleId;
    }

    public void setPartnerVehicleId(UUID partnerVehicleId) {
        this.partnerVehicleId = partnerVehicleId;
    }

    public UUID getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(UUID partnerId) {
        this.partnerId = partnerId;
    }

    public PartnerVehicleType getPartnerVehicleType() {
        return partnerVehicleType;
    }

    public void setPartnerVehicleType(PartnerVehicleType partnerVehicleType) {
        this.partnerVehicleType = partnerVehicleType;
    }

    public String getPartnerVehicleCompany() {
        return partnerVehicleCompany;
    }

    public void setPartnerVehicleCompany(String partnerVehicleCompany) {
        this.partnerVehicleCompany = partnerVehicleCompany;
    }

    public String getPartnerVehicleModelName() {
        return partnerVehicleModelName;
    }

    public void setPartnerVehicleModelName(String partnerVehicleModelName) {
        this.partnerVehicleModelName = partnerVehicleModelName;
    }

    public String getPartnerVehicleModelYear() {
        return partnerVehicleModelYear;
    }

    public void setPartnerVehicleModelYear(String partnerVehicleModelYear) {
        this.partnerVehicleModelYear = partnerVehicleModelYear;
    }

    public String getPartnerVehicleRegistrationNumber() {
        return partnerVehicleRegistrationNumber;
    }

    public void setPartnerVehicleRegistrationNumber(String partnerVehicleRegistrationNumber) {
        this.partnerVehicleRegistrationNumber = partnerVehicleRegistrationNumber;
    }

    public PartnerVehicleNormal() {}

    public PartnerVehicleNormal(UUID partnerVehicleId, UUID partnerId, PartnerVehicleType partnerVehicleType, String partnerVehicleCompany, String partnerVehicleModelName, String partnerVehicleModelYear, String partnerVehicleRegistrationNumber) {
        this.partnerVehicleId = partnerVehicleId;
        this.partnerId = partnerId;
        this.partnerVehicleType = partnerVehicleType;
        this.partnerVehicleCompany = partnerVehicleCompany;
        this.partnerVehicleModelName = partnerVehicleModelName;
        this.partnerVehicleModelYear = partnerVehicleModelYear;
        this.partnerVehicleRegistrationNumber = partnerVehicleRegistrationNumber;
    }
}
