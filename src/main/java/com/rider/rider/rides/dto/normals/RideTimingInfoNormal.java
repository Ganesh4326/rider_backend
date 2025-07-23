package com.rider.rider.rides.dto.normals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RideTimingInfoNormal {
    private String rideTimingInfoId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String rideId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Duration estimatedWaitingTime;
    private Duration actualWaitingTime;
    private LocalDateTime estimatedReachTime;
    private LocalDateTime actualReachTime;
    private LocalDateTime partnerAcceptedTime;
    private LocalDateTime estimatedPartnerArrivalTime;
    private LocalDateTime actualPartnerArrivalTime;
    private Duration estimatedTotalDuration;
    private Duration actualTotalDuration;
}
