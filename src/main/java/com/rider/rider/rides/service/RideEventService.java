package com.rider.rider.rides.service;

import com.rider.rider.rides.dto.normals.RideEventNormal;
import com.rider.rider.rides.dto.requests.CreateRideEventRequest;
import com.rider.rider.rides.dto.requests.GetRideEventByIdRequest;
import com.rider.rider.rides.dto.requests.GetRideEventByRideRequest;
import com.rider.rider.rides.dto.responses.CreateRideEventResponse;
import com.rider.rider.rides.dto.responses.GetAllRideEventsResponse;
import com.rider.rider.rides.dto.responses.GetRideEventByIdResponse;
import com.rider.rider.rides.dto.responses.GetRideEventByRideResponse;
import com.rider.rider.rides.entity.RideEvent;
import com.rider.rider.rides.enums.RideStatus;
import com.rider.rider.rides.repository.RideEventRepository;
import com.rider.rider.rides.util.mapper.RideEventMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RideEventService {
    public final RideEventRepository rideEventRepository;

    public RideEventService(RideEventRepository rideEventRepository) {
        this.rideEventRepository = rideEventRepository;
    }

    public GetRideEventByIdResponse getRideEventById(GetRideEventByIdRequest getRideEventByIdRequest) {
        RideEvent rideEvent = this.rideEventRepository.findById(UUID.fromString(getRideEventByIdRequest.getRideEventId())).orElseThrow();
        return new GetRideEventByIdResponse(RideEventMapper.toNormal(rideEvent));
    }

    public GetRideEventByRideResponse getRideEventByRide(GetRideEventByRideRequest getRideEventByRideRequest) {
        List<RideEvent> rideEventsList = this.rideEventRepository.findAllByRideId(UUID.fromString(getRideEventByRideRequest.getRideId()));
        List<RideEventNormal> rideEventNormalList = rideEventsList.stream().map(RideEventMapper::toNormal).toList();
        return new GetRideEventByRideResponse(rideEventNormalList);
    }

    public GetAllRideEventsResponse getAllRideEvents() {
        List<RideEventNormal> rideEventNormalList = this.rideEventRepository.findAll().stream().map(RideEventMapper::toNormal).toList();
        return new GetAllRideEventsResponse(rideEventNormalList);
    }

    public CreateRideEventResponse createRideEvent(CreateRideEventRequest createRideEventRequest) {
        RideEvent rideEvent = new RideEvent();
        rideEvent.setRideId(UUID.fromString(createRideEventRequest.getRideId()));
        rideEvent.setRideStatus(RideStatus.REQUESTED);
        RideEvent rideEventSaved = this.rideEventRepository.save(rideEvent);
        return new CreateRideEventResponse(rideEventSaved.getId().toString());
    }
}
