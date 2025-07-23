package com.rider.rider.rides.dto.responses;

import com.rider.rider.rides.dto.normals.RideEventNormal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllRideEventsResponse {
    private List<RideEventNormal> rideEvents;
}
