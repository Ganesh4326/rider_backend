package com.rider.rider.rides.dto.normals;

import com.rider.rider.partners.dto.normal.PartnerNormal;
import com.rider.rider.rides.enums.RideStatus;
import com.rider.rider.rides.enums.RideType;
import com.rider.rider.users.dto.normals.UserNormal;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class RideNormal {
    private UUID rideId;
//    private UserNormal user;
    private PartnerNormal partner;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime requestedTime;
    private LocalDateTime acceptedTime;
    private String status;
    private RideType rideType;
    private String dropAddress;
    private String pickupAddress;
    private RideLocationNormal pickupLocation;
    private RideLocationNormal dropLocation;
    private List<RideTrackingNormal> rideTracking;
    private RidePaymentNormal ridePayment;
    private RideStatus rideStatus;
    private Duration estimatedDuration;
    private Duration actualDuration;

    public RideNormal(UUID rideId, UserNormal user, PartnerNormal partner, LocalDateTime createdTime, LocalDateTime updatedTime, LocalDateTime startTime, LocalDateTime endTime, LocalDateTime requestedTime, LocalDateTime acceptedTime, String status, RideType rideType, String dropAddress, String pickupAddress, RideLocationNormal pickupLocation, RideLocationNormal dropLocation, List<RideTrackingNormal> rideTracking, RidePaymentNormal ridePayment, RideStatus rideStatus, Duration estimatedDuration, Duration actualDuration) {
        this.rideId = rideId;
//        this.user = user;
        this.partner = partner;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requestedTime = requestedTime;
        this.acceptedTime = acceptedTime;
        this.status = status;
        this.rideType = rideType;
        this.dropAddress = dropAddress;
        this.pickupAddress = pickupAddress;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.rideTracking = rideTracking;
        this.ridePayment = ridePayment;
        this.rideStatus = rideStatus;
        this.estimatedDuration = estimatedDuration;
        this.actualDuration = actualDuration;
    }

    public UUID getRideId() {
        return rideId;
    }

    public void setRideId(UUID rideId) {
        this.rideId = rideId;
    }

//    public UserNormal getUser() {
//        return user;
//    }
//
//    public void setUser(UserNormal user) {
//        this.user = user;
//    }

    public PartnerNormal getPartner() {
        return partner;
    }

    public void setPartner(PartnerNormal partner) {
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

    public RideType getRideType() {
        return rideType;
    }

    public void setRideType(RideType rideType) {
        this.rideType = rideType;
    }

    public String getDropAddress() {
        return dropAddress;
    }

    public void setDropAddress(String dropAddress) {
        this.dropAddress = dropAddress;
    }

    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public RideLocationNormal getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(RideLocationNormal pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public RideLocationNormal getDropLocation() {
        return dropLocation;
    }

    public void setDropLocation(RideLocationNormal dropLocation) {
        this.dropLocation = dropLocation;
    }

    public List<RideTrackingNormal> getRideTracking() {
        return rideTracking;
    }

    public void setRideTracking(List<RideTrackingNormal> rideTracking) {
        this.rideTracking = rideTracking;
    }

    public RidePaymentNormal getRidePayment() {
        return ridePayment;
    }

    public void setRidePayment(RidePaymentNormal ridePayment) {
        this.ridePayment = ridePayment;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
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
}
