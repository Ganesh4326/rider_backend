package com.rider.rider.rides.dto.normals;

import com.rider.rider.rides.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RideEventNormal {
    private String rideEventId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String rideId;
    private String metaData;
    private RideStatus rideStatus;
}
