package com.rider.rider.rides.entity;

import com.rider.rider.partners.entity.Partner;
import com.rider.rider.rides.enums.RideStatus;
import com.rider.rider.rides.enums.RideType;
import com.rider.rider.rides.util.converters.DurationToLongConverter;
import com.rider.rider.users.entity.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "rides")
public class Ride {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ride_id", nullable = false, updatable = false, columnDefinition = "UUID")
    private UUID rideId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    @OneToOne(mappedBy = "currentRide", fetch = FetchType.LAZY)
    private Partner partner;

    @CreationTimestamp
    @Column(name = "created_time", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private LocalDateTime createdTime;

    @UpdateTimestamp
    @Column(name = "updated_time", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private LocalDateTime updatedTime;

    @Column(name = "requested_time")
    private LocalDateTime requestedTime;

    @Column(name = "accepted_time")
    private LocalDateTime acceptedTime;

    @Column(name = "status")
    private String status;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Enumerated
    @Column(name = "ride_type")
    private RideType rideType;

    @OneToMany(mappedBy = "ride", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "locations")
    private List<RideLocation> locations;

    @Column(name = "pickup_address")
    private String pickupAddress;

    @Column(name = "drop_address")
    private String dropAddress;

    @OneToMany(mappedBy = "ride", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "trackings")
    private List<RideTracking> tracking;

    @OneToOne(mappedBy = "ride", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private RidePayment ridePayment;

    @Convert(converter = DurationToLongConverter.class)
    @Column(name = "estimated_duration", nullable = false)
    private Duration estimatedDuration;

    @Convert(converter = DurationToLongConverter.class)
    @Column(name = "actual_duration")
    private Duration actualDuration;

    @Enumerated(EnumType.STRING)
    @Column(name = "ride_status", nullable = false)
    private RideStatus rideStatus;

    @Column(name = "distance_km")
    private Double distanceKm;

    public UUID getRideId() {
        return rideId;
    }

    public void setRideId(UUID rideId) {
        this.rideId = rideId;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public LocalDateTime getRequestedTime() {
        return requestedTime;
    }

    public void setRequestedTime(LocalDateTime requestedTime) {
        this.requestedTime = requestedTime;
    }

    public LocalDateTime getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(LocalDateTime acceptedTime) {
        this.acceptedTime = acceptedTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public RideType getRideType() {
        return rideType;
    }

    public void setRideType(RideType rideType) {
        this.rideType = rideType;
    }

    public List<RideLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<RideLocation> locations) {
        this.locations = locations;
    }

    public String getDropAddress() {
        return dropAddress;
    }

    public void setDropAddress(String dropAddress) {
        this.dropAddress = dropAddress;
    }

    public List<RideTracking> getTracking() {
        return tracking;
    }

    public void setTracking(List<RideTracking> tracking) {
        this.tracking = tracking;
    }

    public RidePayment getRidePayment() {
        return ridePayment;
    }

    public void setRidePayment(RidePayment payment) {
        this.ridePayment = payment;
    }

    public Duration getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(Duration estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public Duration getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(Duration actualDuration) {
        this.actualDuration = actualDuration;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public Double getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(Double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }
}
