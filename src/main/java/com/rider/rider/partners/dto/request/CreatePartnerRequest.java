package com.rider.rider.partners.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePartnerRequest {
    private String userId;
    private Double partnerLocationLatitude;
    private Double partnerLocationLongitude;
}
