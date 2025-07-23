package com.rider.rider.partners.controller;

import com.rider.rider.partners.dto.request.CreatePartnerRequest;
import com.rider.rider.partners.dto.request.GetNearbyAvailablePartnersRequest;
import com.rider.rider.partners.dto.response.CreatePartnerResponse;
import com.rider.rider.partners.dto.response.GetNearbyAvailablePartnersResponse;
import com.rider.rider.partners.dto.response.GetPartnerByIdResponse;
import com.rider.rider.partners.service.PartnerService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{partnerId}")
    public GetPartnerByIdResponse getPartnerById(@PathVariable String partnerId) {
        return this.partnerService.getPartnerById(partnerId);
    }

    @GetMapping("/nearby")
    public GetNearbyAvailablePartnersResponse getNearbyAvailablePartners(
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {
        return this.partnerService.getNearbyAvailablePartners(new GetNearbyAvailablePartnersRequest(latitude, longitude));
    }
}
