package com.rider.rider.rides.controller;

import com.rider.rider.rides.dto.requests.CreateRideEventRequest;
import com.rider.rider.rides.dto.requests.GetRideEventByIdRequest;
import com.rider.rider.rides.dto.requests.GetRideEventByRideRequest;
import com.rider.rider.rides.dto.responses.CreateRideEventResponse;
import com.rider.rider.rides.dto.responses.GetAllRideEventsResponse;
import com.rider.rider.rides.dto.responses.GetRideEventByIdResponse;
import com.rider.rider.rides.dto.responses.GetRideEventByRideResponse;
import com.rider.rider.rides.service.RideEventService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rideevents")
public class RideEventController {
    public final RideEventService rideEventService;

    public RideEventController(RideEventService rideEventService) {
        this.rideEventService = rideEventService;
    }

    @GetMapping("/{rideEventId}")
    private GetRideEventByIdResponse getRideEventById(@PathVariable String rideEventId) {
        return this.rideEventService.getRideEventById(new GetRideEventByIdRequest(rideEventId));
    }

    @GetMapping("/{rideId}")
    private GetRideEventByRideResponse getRideEventByRide(@PathVariable String rideId) {
        return this.rideEventService.getRideEventByRide(new GetRideEventByRideRequest(rideId));
    }

    @GetMapping("/all")
    private GetAllRideEventsResponse getAllRides() {
        return this.rideEventService.getAllRideEvents();
    }

    @PostMapping("/create")
    public CreateRideEventResponse createRideEvent(@RequestBody CreateRideEventRequest createRideEventRequest) {
        return this.rideEventService.createRideEvent(createRideEventRequest);
    }
}
