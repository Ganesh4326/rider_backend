package com.rider.rider.partners.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachPartnerToRideRequest {
    private String rideId;
    private String partnerId;
}
