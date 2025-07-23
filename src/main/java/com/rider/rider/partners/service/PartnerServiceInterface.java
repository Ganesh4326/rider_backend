package com.rider.rider.partners.service;

import com.rider.rider.partners.dto.request.AttachPartnerToRideRequest;
import com.rider.rider.partners.dto.request.CreatePartnerRequest;
import com.rider.rider.partners.dto.response.CreatePartnerResponse;
import com.rider.rider.partners.dto.response.GetPartnerByIdResponse;

public interface PartnerServiceInterface {
    CreatePartnerResponse createPartner(CreatePartnerRequest createPartnerRequest);
    GetPartnerByIdResponse getPartnerById(String partnerId);
    void attachPartnerToRide(AttachPartnerToRideRequest attachPartnerToRideRequest);
}
