package com.rider.rider.rides.entity;

import com.rider.rider.rides.enums.RideLocationType;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "ride_locations")
public class RideLocation {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "ride_location_id", nullable = false, updatable = false, columnDefinition = "UUID")
    private UUID rideLocationId;

    @Enumerated(EnumType.STRING)
    @Column(name = "ride_location_type", nullable = false)
    private RideLocationType rideLocationType;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ride_id", nullable = false)
    private Ride ride;

    public UUID getRideLocationId() {
        return rideLocationId;
    }

    public void setRideLocationId(UUID rideLocationId) {
        this.rideLocationId = rideLocationId;
    }

    public RideLocationType getLocationType() {
        return rideLocationType;
    }

    public void setLocationType(RideLocationType rideLocationType) {
        this.rideLocationType = rideLocationType;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }
}
