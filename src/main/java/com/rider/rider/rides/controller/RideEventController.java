package com.rider.rider.rides.controller;

import com.rider.rider.rides.dto.requests.CreateRideEventRequest;
import com.rider.rider.rides.dto.responses.CreateRideEventResponse;
import com.rider.rider.rides.service.RideEventService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rideevents")
public class RideEventController {
    public final RideEventService rideEventService;

    public RideEventController(RideEventService rideEventService) {
        this.rideEventService = rideEventService;
    }

    @PostMapping("/create")
    public CreateRideEventResponse createRideEvent(@RequestBody CreateRideEventRequest createRideEventRequest) {
        return this.rideEventService.createRideEvent(createRideEventRequest);
    }
}
