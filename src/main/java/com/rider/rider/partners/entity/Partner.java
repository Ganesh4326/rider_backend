package com.rider.rider.partners.entity;

import com.rider.rider.partners.enums.Gender;
import com.rider.rider.partners.enums.PartnerCurrentStatus;
import com.rider.rider.partners.enums.PartnerStatus;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.rides.entity.RideLocation;
import com.rider.rider.users.entity.User;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "partners")
public class Partner {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "partner_id", nullable = false, updatable = false, columnDefinition = "UUID")
    private UUID partnerId;

    @Enumerated
    @Column(name = "partner_current_status")
    private PartnerCurrentStatus partnerCurrentStatus = PartnerCurrentStatus.AVAILABLE;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_vehicle_id")
    private PartnerVehicle partnerVehicle;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "partner_location_id")
    private PartnerLocation partnerLocation;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_ride_id")
    private Ride currentRide;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @Column(name = "total_rides_completed")
    private Integer totalRidesCompleted;

    @Column(name = "is_verified")
    private Boolean isVerified = false;

    @Enumerated
    @Column(name = "partner_status")
    private PartnerStatus partnerStatus = PartnerStatus.ACTIVE;

    public UUID getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(UUID partnerId) {
        this.partnerId = partnerId;
    }

    public PartnerCurrentStatus getPartnerCurrentStatus() {
        return partnerCurrentStatus;
    }

    public void setPartnerCurrentStatus(PartnerCurrentStatus partnerCurrentStatus) {
        this.partnerCurrentStatus = partnerCurrentStatus;
    }

    public PartnerVehicle getPartnerVehicle() {
        return partnerVehicle;
    }

    public void setPartnerVehicle(PartnerVehicle partnerVehicle) {
        this.partnerVehicle = partnerVehicle;
    }

    public PartnerLocation getPartnerLocation() {
        return partnerLocation;
    }

    public void setPartnerLocation(PartnerLocation partnerLocation) {
        this.partnerLocation = partnerLocation;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Ride getCurrentRide() {
        return currentRide;
    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide = currentRide;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getTotalRidesCompleted() {
        return totalRidesCompleted;
    }

    public void setTotalRidesCompleted(Integer totalRidesCompleted) {
        this.totalRidesCompleted = totalRidesCompleted;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public PartnerStatus getPartnerStatus() {
        return partnerStatus;
    }

    public void setPartnerStatus(PartnerStatus partnerStatus) {
        this.partnerStatus = partnerStatus;
    }
}
