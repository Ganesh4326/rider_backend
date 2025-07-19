package com.rider.rider.partners.controller;

import com.rider.rider.partners.dto.request.CreatePartnerRequest;
import com.rider.rider.partners.dto.response.CreatePartnerResponse;
import com.rider.rider.partners.service.PartnerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("partners/")
public class PartnerController {
    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping("/create")
    public CreatePartnerResponse createPartner(@RequestBody CreatePartnerRequest createPartnerRequest) {
        return this.partnerService.createPartner(createPartnerRequest);
    }
}
