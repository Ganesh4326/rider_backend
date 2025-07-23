package com.rider.rider.rides.entity;

import com.rider.rider.core.entity.BaseEntity;
import com.rider.rider.rides.enums.RideStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ride_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "ride_event_id", nullable = false, updatable = false, columnDefinition = "UUID"))
public class RideEvent extends BaseEntity {

    @Column(name = "ride_id", nullable = false)
    private UUID rideId;

    @Column(name = "meta_data")
    private String metaData;

    @Enumerated(EnumType.STRING)
    @Column(name = "ride_status", nullable = false)
    private RideStatus rideStatus;
}
