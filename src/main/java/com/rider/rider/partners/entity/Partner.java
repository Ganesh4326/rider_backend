package com.rider.rider.partners.entity;

import com.rider.rider.core.entity.BaseEntity;
import com.rider.rider.locations.entity.Location;
import com.rider.rider.partners.enums.PartnerCurrentStatus;
import com.rider.rider.partners.enums.PartnerStatus;
import com.rider.rider.partners.enums.PartnerVerificationStatus;
import com.rider.rider.rides.entity.Ride;
import com.rider.rider.users.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "partners")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "partner_id", nullable = false, updatable = false, columnDefinition = "UUID"))
public class Partner extends BaseEntity {
    @OneToMany(mappedBy = "partner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<PartnerVehicle> partnerVehicles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "current_location_id")
    private Location currentLocation;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "partner")
    private Ride currentRide;

    @Column(name = "rating", nullable = false)
    private Double rating;

    @Column(name = "total_rides_completed")
    private Integer totalRidesCompleted;

    @Column(name = "total_rides_rejected")
    private Integer totalRidesRejected;

    @Column(name = "total_amount_earned")
    private BigDecimal totalAmountEarned;

    @Enumerated(EnumType.STRING)
    @Column(name = "verification_status")
    private PartnerVerificationStatus verificationStatus = PartnerVerificationStatus.PENDING;

    @Enumerated(EnumType.STRING)
    @Column(name = "partner_status")
    private PartnerStatus partnerStatus = PartnerStatus.ACTIVE;

    @Enumerated(EnumType.STRING)
    @Column(name = "partner_current_status")
    private PartnerCurrentStatus partnerCurrentStatus = PartnerCurrentStatus.AVAILABLE;
}
