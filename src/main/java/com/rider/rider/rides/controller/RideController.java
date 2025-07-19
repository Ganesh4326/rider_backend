package com.rider.rider.rides.controller;

import com.rider.rider.rides.dto.requests.AttachRideToPartnerRequest;
import com.rider.rider.rides.dto.requests.CreateRideRequest;
import com.rider.rider.rides.dto.requests.UpdateRideStatusRequest;
import com.rider.rider.rides.dto.responses.CreateRideResponse;
import com.rider.rider.rides.dto.responses.GetRideResponse;
import com.rider.rider.rides.service.RideService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rides")
public class RideController {
    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping("/{rideId}")
    public Optional<GetRideResponse> createRide(@PathVariable UUID rideId) {
        return rideService.getRideById(rideId);
    }

    @PostMapping("/create")
    public CreateRideResponse createRide(@RequestBody CreateRideRequest createRideRequest) {
        return rideService.createRide(createRideRequest);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateRideStatus(@RequestBody UpdateRideStatusRequest updateRideStatusRequest) {
        this.rideService.updateRideStatus(updateRideStatusRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/attachtopartner")
    public ResponseEntity<Void> attachRideToPartner(@RequestBody AttachRideToPartnerRequest attachRideToPartnerRequest) {
        this.rideService.attachRideToPartner(attachRideToPartnerRequest);
        return ResponseEntity.ok().build();
    }
}
