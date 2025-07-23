package com.rider.rider.partners.dto.normal;

import com.rider.rider.partners.enums.PartnerVehicleColor;
import com.rider.rider.partners.enums.PartnerVehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartnerVehicleNormal {
    private String partnerVehicleId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String partnerId;
    private PartnerVehicleModelNormal partnerVehicleModel;
    private String partnerVehicleRegistrationNumber;
    private PartnerVehicleType partnerVehicleType;
    private PartnerVehicleColor partnerVehicleColor;
}
