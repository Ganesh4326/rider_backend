package com.rider.rider.rides.controller;

import com.rider.rider.rides.dto.requests.AttachPartnerToRideRequestRequest;
import com.rider.rider.rides.dto.requests.CreateRideRequestRequest;
import com.rider.rider.rides.dto.requests.GetRideRequestByIdRequest;
import com.rider.rider.rides.dto.responses.CreateRideRequestResponse;
import com.rider.rider.rides.dto.responses.GetAllRideRequestsResponse;
import com.rider.rider.rides.dto.responses.GetRideRequestByIdResponse;
import com.rider.rider.rides.service.RideRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/riderequests")
public class RideRequestController {
    @Autowired
    private RideRequestService rideRequestService;

    @GetMapping("/{rideRequestId}")
    private GetRideRequestByIdResponse getAllRideRequests(@PathVariable String rideRequestId) {
        return this.rideRequestService.getRideRequestById(new GetRideRequestByIdRequest(rideRequestId));
    }

    @GetMapping("/all")
    private GetAllRideRequestsResponse getAllRideRequests() {
        return this.rideRequestService.getAllRideRequests();
    }

    @PostMapping("/create")
    private CreateRideRequestResponse createRideRequest(@RequestBody CreateRideRequestRequest createRideRequestRequest) {
        return this.rideRequestService.createRideRequest(createRideRequestRequest);
    }

    @PutMapping("/update/acceptedpartner")
    private ResponseEntity<Void> attachPartnerToRideRequest(@RequestBody AttachPartnerToRideRequestRequest attachPartnerToRideRequestRequest) {
        this.rideRequestService.attachPartnerToRideRequest(attachPartnerToRideRequestRequest);
        return ResponseEntity.ok().build();
    }
}
