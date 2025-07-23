package com.rider.rider.rides.entity;

import com.rider.rider.core.entity.BaseEntity;
import com.rider.rider.locations.entity.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ride_location_infos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "ride_location_info_id", nullable = false, updatable = false, columnDefinition = "UUID"))
public class RideLocationInfo extends BaseEntity {
    @OneToOne(mappedBy = "rideLocationInfo")
    private Ride ride;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pickup_location_id", nullable = false)
    private Location pickupLocation;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "drop_location_id", nullable = false)
    private Location dropLocation;

    @Column(name = "destination_distance")
    private Double destinationDistanceInMeters;

    @Column(name = "partner_distance")
    private Double partnerDistanceInMeters;
}
