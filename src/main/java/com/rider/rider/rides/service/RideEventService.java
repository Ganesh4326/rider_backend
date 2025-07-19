package com.rider.rider.rides.service;

import com.rider.rider.rides.dto.requests.CreateRideEventRequest;
import com.rider.rider.rides.dto.responses.CreateRideEventResponse;
import com.rider.rider.rides.entity.RideEvent;
import com.rider.rider.rides.enums.RideStatus;
import com.rider.rider.rides.repository.RideEventRepository;
import org.springframework.stereotype.Service;

@Service
public class RideEventService {
    public final RideEventRepository rideEventRepository;

    public RideEventService(RideEventRepository rideEventRepository) {
        this.rideEventRepository = rideEventRepository;
    }

    public CreateRideEventResponse createRideEvent(CreateRideEventRequest createRideEventRequest) {
        RideEvent rideEvent = new RideEvent();
        rideEvent.setRideId(createRideEventRequest.getRideId());
        rideEvent.setRideStatus(RideStatus.REQUESTED);
        RideEvent rideEventSaved = this.rideEventRepository.save(rideEvent);
        return new CreateRideEventResponse(rideEventSaved.getRideEventId());
    }
}
