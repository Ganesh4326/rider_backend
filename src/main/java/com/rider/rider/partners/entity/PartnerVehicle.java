package com.rider.rider.partners.entity;

import com.rider.rider.partners.enums.PartnerVehicleType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "partner_vehicles")
public class PartnerVehicle {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "vehicle_id", nullable = false, updatable = false, columnDefinition = "UUID")
    private UUID partnerVehicleId;

    @OneToOne(mappedBy = "partnerVehicle", fetch = FetchType.LAZY)
    private Partner partner;

    @Column(name = "vehicle_type", nullable = false)
    private PartnerVehicleType partnerVehicleType;

    @Column(name = "vehicle_company", nullable = false)
    private String partnerVehicleCompany;

    @Column(name = "vehicle_model_name", nullable = false)
    private String partnerVehicleModelName;

    @Column(name = "vehicle_model_year", nullable = false)
    private String partnerVehicleModelYear;

    @Column(name = "vehicle_registration_number", nullable = false)
    private String partnerVehicleRegistrationNumber;

    public UUID getPartnerVehicleId() {
        return partnerVehicleId;
    }

    public void setPartnerVehicleId(UUID partnerVehicleId) {
        this.partnerVehicleId = partnerVehicleId;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
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
}
