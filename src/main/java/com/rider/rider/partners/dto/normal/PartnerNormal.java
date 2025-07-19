package com.rider.rider.partners.dto.normal;

import com.rider.rider.partners.enums.PartnerCurrentStatus;
import com.rider.rider.partners.enums.PartnerStatus;
import com.rider.rider.rides.dto.normals.RideNormal;
import com.rider.rider.users.dto.normals.UserNormal;

public class PartnerNormal {
    private String partnerId;
    private PartnerCurrentStatus partnerCurrentStatus;
    private PartnerVehicleNormal partnerVehicleNormal;
    private PartnerLocationNormal partnerLocationNormal;
    private UserNormal userNormal;
    private RideNormal currentRideNormal;
    private Double rating;
    private Integer totalRidesCompleted;
    private Boolean isVerified = false;
    private PartnerStatus partnerStatus;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public PartnerCurrentStatus getPartnerCurrentStatus() {
        return partnerCurrentStatus;
    }

    public void setPartnerCurrentStatus(PartnerCurrentStatus partnerCurrentStatus) {
        this.partnerCurrentStatus = partnerCurrentStatus;
    }

    public PartnerVehicleNormal getPartnerVehicleNormal() {
        return partnerVehicleNormal;
    }

    public void setPartnerVehicleNormal(PartnerVehicleNormal partnerVehicleNormal) {
        this.partnerVehicleNormal = partnerVehicleNormal;
    }

    public PartnerLocationNormal getPartnerLocationNormal() {
        return partnerLocationNormal;
    }

    public void setPartnerLocationNormal(PartnerLocationNormal partnerLocationNormal) {
        this.partnerLocationNormal = partnerLocationNormal;
    }

    public UserNormal getUserNormal() {
        return userNormal;
    }

    public void setUserNormal(UserNormal userNormal) {
        this.userNormal = userNormal;
    }

    public RideNormal getCurrentRideNormal() {
        return currentRideNormal;
    }

    public void setCurrentRideNormal(RideNormal currentRideNormal) {
        this.currentRideNormal = currentRideNormal;
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

    public PartnerNormal(){}

    public PartnerNormal(String partnerId, PartnerCurrentStatus partnerCurrentStatus, PartnerVehicleNormal partnerVehicleNormal, PartnerLocationNormal partnerLocationNormal, UserNormal userNormal, RideNormal currentRideNormal, Double rating, Integer totalRidesCompleted, Boolean isVerified, PartnerStatus partnerStatus) {
        this.partnerId = partnerId;
        this.partnerCurrentStatus = partnerCurrentStatus;
        this.partnerVehicleNormal = partnerVehicleNormal;
        this.partnerLocationNormal = partnerLocationNormal;
        this.userNormal = userNormal;
        this.currentRideNormal = currentRideNormal;
        this.rating = rating;
        this.totalRidesCompleted = totalRidesCompleted;
        this.isVerified = isVerified;
        this.partnerStatus = partnerStatus;
    }
}
