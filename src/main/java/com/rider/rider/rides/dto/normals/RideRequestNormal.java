package com.rider.rider.rides.dto.normals;

import com.rider.rider.partners.dto.normal.PartnerNormal;
import com.rider.rider.rides.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestNormal {
    private String rideRequestId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private RideNormal ride;
    private List<PartnerNormal> nearbyPartners;
    private PartnerNormal acceptedPartner;
    private RideRequestStatus rideRequestStatus;
}
