package com.rider.rider.partners.controller;

import com.rider.rider.partners.dto.request.AddPartnerVehicleRequest;
import com.rider.rider.partners.dto.request.GetPartnerVehicleByIdRequest;
import com.rider.rider.partners.dto.request.GetPartnerVehicleByPartnerRequest;
import com.rider.rider.partners.dto.request.UpdatePartnerVehicleRequest;
import com.rider.rider.partners.dto.response.AddPartnerVehicleResponse;
import com.rider.rider.partners.dto.response.GetAllPartnerVehiclesResponse;
import com.rider.rider.partners.dto.response.GetPartnerVehicleByIdResponse;
import com.rider.rider.partners.dto.response.GetPartnerVehicleByPartnerResponse;
import com.rider.rider.partners.service.PartnerVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partnervehicle")
public class PartnerVehicleController {
    @Autowired
    private PartnerVehicleService partnerVehicleService;

    @GetMapping("/{partnerVehicleId}")
    private GetPartnerVehicleByIdResponse getPartnerVehicleById(@PathVariable String partnerVehicleId) {
        return this.partnerVehicleService.getPartnerVehicleById(new GetPartnerVehicleByIdRequest(partnerVehicleId));
    }

    @GetMapping("/{partnerId}")
    private GetPartnerVehicleByPartnerResponse getPartnerVehicleByPartner(@PathVariable String partnerId) {
        return this.partnerVehicleService.getPartnerVehicleByPartner(new GetPartnerVehicleByPartnerRequest(partnerId));
    }

    @GetMapping("/all")
    private GetAllPartnerVehiclesResponse getAllRides() {
        return this.partnerVehicleService.getAllPartnerVehiclesResponse();
    }

    @PostMapping("/create")
    public AddPartnerVehicleResponse addPartnerVehicle(@RequestBody AddPartnerVehicleRequest addPartnerVehicleRequest) {
        return this.partnerVehicleService.addPartnerVehicle(addPartnerVehicleRequest);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updatePartnerVehicle(@RequestBody UpdatePartnerVehicleRequest updatePartnerVehicleRequest) {
        this.partnerVehicleService.updatePartnerVehicle(updatePartnerVehicleRequest);
        return ResponseEntity.ok().build();
    }
}
