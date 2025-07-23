package com.rider.rider.rides.entity;

import com.rider.rider.core.entity.BaseEntity;
import com.rider.rider.partners.entity.Partner;
import com.rider.rider.rides.enums.RideRequestStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "ride_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "ride_request_id", nullable = false, updatable = false, columnDefinition = "UUID"))
public class RideRequest extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ride_id", nullable = false)
    private Ride ride;

    @ManyToMany
    @JoinTable(
            name = "partner_ride_requests",
            joinColumns = @JoinColumn(name = "ride_request_id"),
            inverseJoinColumns = @JoinColumn(name = "partner_id")
    )
    private List<Partner> nearbyPartners;

    @OneToOne
    @JoinColumn(name = "accepted_partner_id")
    private Partner acceptedPartner;

    @Column(name = "ride_request_status", nullable = false)
    private RideRequestStatus rideRequestStatus;
}
