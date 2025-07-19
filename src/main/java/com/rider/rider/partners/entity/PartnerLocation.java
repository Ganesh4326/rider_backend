package com.rider.rider.partners.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "partner_locations")
public class PartnerLocation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "partner_location_id", nullable = false, updatable = false, columnDefinition = "UUID")
    private UUID partnerLocationId;

    @OneToOne(mappedBy = "partnerLocation")
    private Partner partner;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @UpdateTimestamp
    @Column(name = "location_updated_at", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private LocalDateTime locationUpdatedAt = LocalDateTime.now();

    public UUID getPartnerLocationId() {
        return partnerLocationId;
    }

    public void setPartnerLocationId(UUID partnerLocationId) {
        this.partnerLocationId = partnerLocationId;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
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

    public LocalDateTime getLocationUpdatedAt() {
        return locationUpdatedAt;
    }

    public void setLocationUpdatedAt(LocalDateTime locationUpdatedAt) {
        this.locationUpdatedAt = locationUpdatedAt;
    }
}
