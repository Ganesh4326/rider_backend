package com.rider.rider.partners.dto.request;

import com.rider.rider.partners.enums.PartnerVehicleColor;
import com.rider.rider.partners.enums.PartnerVehicleCompany;
import com.rider.rider.partners.enums.PartnerVehicleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePartnerVehicleRequest {
    private String partnerVehicleId;
    private String partnerId;
    private String modelName;
    private String modelYear;
    private PartnerVehicleCompany partnerVehicleCompany;
    private String partnerVehicleRegistrationNumber;
    private PartnerVehicleType partnerVehicleType;
    private PartnerVehicleColor partnerVehicleColor;
}
