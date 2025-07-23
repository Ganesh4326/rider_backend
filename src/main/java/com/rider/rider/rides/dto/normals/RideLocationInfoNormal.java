package com.rider.rider.rides.dto.normals;

import com.rider.rider.locations.dto.normals.LocationNormal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RideLocationInfoNormal {
    private String rideLocationInfoId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String rideId;
    private LocationNormal pickupLocation;
    private LocationNormal dropLocation;
    private Double destinationDistanceInMeters;
    private Double partnerDistanceInMeters;
}
