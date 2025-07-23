package com.rider.rider.partners.repository;

import com.rider.rider.partners.entity.PartnerVehicle;
import com.rider.rider.partners.entity.PartnerVehicleModel;
import com.rider.rider.rides.entity.RideEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PartnerVehicleRepository extends JpaRepository<PartnerVehicle, UUID> {
    List<PartnerVehicle> findAllByPartner_Id(UUID partnerId);
}
