package com.rider.rider.partners.dto.request;

import com.rider.rider.partners.enums.PartnerVehicleColor;
import com.rider.rider.partners.enums.PartnerVehicleCompany;
import com.rider.rider.partners.enums.PartnerVehicleType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPartnerVehicleRequest {
    private String partnerId;
    private PartnerVehicleCompany partnerVehicleCompany;
    private String partnerVehicleModelName;
    private String partnerVehicleModelYear;
    private String partnerVehicleRegistrationNumber;
    private PartnerVehicleType partnerVehicleType;
    private PartnerVehicleColor partnerVehicleColor;
}
