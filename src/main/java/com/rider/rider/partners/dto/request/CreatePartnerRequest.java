package com.rider.rider.partners.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreatePartnerRequest {
    private String email;
    private String name;
    private String phone;
    private String password;
    private Double partnerLocationLatitude;
    private Double partnerLocationLongitude;
}
