package com.rider.rider.partners.dto.response;

import java.util.UUID;

public class CreatePartnerResponse {
    private UUID partnerId;

    public CreatePartnerResponse(UUID partnerId) {
        this.partnerId = partnerId;
    }

    public UUID getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(UUID partnerId) {
        this.partnerId = partnerId;
    }
}
