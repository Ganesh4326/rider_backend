package com.rider.rider.partners.dto.normal;

import com.rider.rider.partners.enums.PartnerVehicleCompany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartnerVehicleModelNormal {
    private String partnerVehicleModelId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String partnerVehicleId;
    private String modelName;
    private String modelYear;
    private PartnerVehicleCompany company;
}
