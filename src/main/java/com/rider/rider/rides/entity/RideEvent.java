package com.rider.rider.rides.entity;

import com.rider.rider.rides.enums.RideStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ride_events")
public class RideEvent {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ride_event_id", nullable = false, updatable = false, columnDefinition = "UUID")
    private UUID rideEventId;

    @Column(name = "ride_id", nullable = false)
    private UUID rideId;

    @Column(name = "ride_status", nullable = false)
    private RideStatus rideStatus;

    @CreationTimestamp
    @Column(name = "created_time", nullable = false, columnDefinition = "TIMESTAMPTZ")
    private LocalDateTime createdTime;

    @Column(name = "meta_data")
    private String metaData;

    public UUID getRideEventId() {
        return rideEventId;
    }

    public void setRideEventId(UUID rideEventId) {
        this.rideEventId = rideEventId;
    }

    public UUID getRideId() {
        return rideId;
    }

    public void setRideId(UUID rideId) {
        this.rideId = rideId;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public void setRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }
}
