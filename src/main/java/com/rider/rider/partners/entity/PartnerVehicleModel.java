package com.rider.rider.partners.entity;

import com.rider.rider.core.entity.BaseEntity;
import com.rider.rider.partners.enums.PartnerVehicleCompany;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "partner_vehicle_models")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "partner_vehicle_model_id", nullable = false, updatable = false, columnDefinition = "UUID"))
public class PartnerVehicleModel extends BaseEntity {
    @OneToOne(mappedBy = "partnerVehicleModel")
    private PartnerVehicle partnerVehicle;

    @Column(name = "partner_vehicle_model_name", nullable = false)
    private String modelName;

    @Column(name = "partner_vehicle_model_year", nullable = false)
    private String modelYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "partner_vehicle_company", nullable = false)
    private PartnerVehicleCompany company;
}
