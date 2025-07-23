package com.rider.rider.rides.dto.responses;

import com.rider.rider.rides.dto.normals.RideRequestNormal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllRideRequestsResponse {
    private List<RideRequestNormal> rideRequests;
}
