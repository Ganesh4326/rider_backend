package com.rider.rider.partners.repository;

import com.rider.rider.partners.entity.PartnerVehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartnerVehicleModelRepository extends JpaRepository<PartnerVehicleModel, UUID> {
}
