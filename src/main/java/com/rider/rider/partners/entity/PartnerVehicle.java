package com.rider.rider.partners.entity;

import com.rider.rider.core.entity.BaseEntity;
import com.rider.rider.partners.enums.PartnerVehicleColor;
import com.rider.rider.partners.enums.PartnerVehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partner_vehicles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "partner_vehicle_id", nullable = false, updatable = false, columnDefinition = "UUID"))
public class PartnerVehicle extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_id", nullable = false)
    private Partner partner;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "partner_vehicle_model_id")
    private PartnerVehicleModel partnerVehicleModel;

    @Column(name = "partner_vehicle_registration_number", nullable = false, unique = true)
    private String partnerVehicleRegistrationNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "partner_vehicle_type", nullable = false)
    private PartnerVehicleType partnerVehicleType;

    @Enumerated(EnumType.STRING)
    @Column(name = "partner_vehicle_color", nullable = false)
    private PartnerVehicleColor color;
}
