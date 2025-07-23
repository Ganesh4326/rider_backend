package com.rider.rider.rides.entity;

import com.rider.rider.core.entity.BaseEntity;
import com.rider.rider.rides.util.converters.DurationToLongConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "ride_timing_infos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "ride_timing_info_id", nullable = false, updatable = false, columnDefinition = "UUID"))
public class RideTimingInfo extends BaseEntity {
    @OneToOne(mappedBy = "rideTimingInfo")
    private Ride ride;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Convert(converter = DurationToLongConverter.class)
    @Column(name = "estimated_waiting_time")
    private Duration estimatedWaitingTime;

    @Convert(converter = DurationToLongConverter.class)
    @Column(name = "actual_waiting_time")
    private Duration actualWaitingTime;

    @Column(name = "estimated_reach_time")
    private LocalDateTime estimatedReachTime;

    @Column(name = "actual_reach_time")
    private LocalDateTime actualReachTime;

    @Column(name = "partner_accepted_time")
    private LocalDateTime partnerAcceptedTime;

    @Column(name = "estimated_partner_arrival_time")
    private LocalDateTime estimatedPartnerArrivalTime;

    @Column(name = "actual_partner_arrival_time")
    private LocalDateTime actualPartnerArrivalTime;

    @Convert(converter = DurationToLongConverter.class)
    @Column(name = "estimated_total_duration")
    private Duration estimatedTotalDuration;

    @Convert(converter = DurationToLongConverter.class)
    @Column(name = "actual_total_duration")
    private Duration actualTotalDuration;
}
