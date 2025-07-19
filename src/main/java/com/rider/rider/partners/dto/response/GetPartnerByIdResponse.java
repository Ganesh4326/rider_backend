package com.rider.rider.partners.dto.response;

import com.rider.rider.partners.dto.normal.PartnerNormal;

public class GetPartnerByIdResponse {
    private PartnerNormal partnerNormal;

    public GetPartnerByIdResponse(PartnerNormal partnerNormal) {
        this.partnerNormal = partnerNormal;
    }

    public PartnerNormal getPartnerNormal() {
        return partnerNormal;
    }

    public void setPartnerNormal(PartnerNormal partnerNormal) {
        this.partnerNormal = partnerNormal;
    }
}
