package com.rider.rider.partners.dto.normal;

import com.rider.rider.locations.dto.normals.LocationNormal;
import com.rider.rider.partners.enums.PartnerCurrentStatus;
import com.rider.rider.partners.enums.PartnerStatus;
import com.rider.rider.partners.enums.PartnerVerificationStatus;
import com.rider.rider.users.dto.normals.UserNormal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartnerNormal {
    private String partnerId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<PartnerVehicleNormal> partnerVehicles;
    private LocationNormal currentLocation;
    private UserNormal user;
    private String currentRideId;
    private Double rating;
    private Integer totalRidesCompleted;
    private Integer totalRidesRejected;
    private BigDecimal totalAmountEarned;
    private PartnerVerificationStatus verificationStatus;
    private PartnerStatus partnerStatus;
    private PartnerCurrentStatus partnerCurrentStatus;
}
