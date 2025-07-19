package com.rider.rider.partners.service;

import com.rider.rider.partners.repository.PartnerVehicleRepository;
import org.springframework.stereotype.Service;

@Service
public class PartnerVehicleService {
    private final PartnerVehicleRepository partnerVehicleRepository;

    public PartnerVehicleService(PartnerVehicleRepository partnerVehicleRepository) {
        this.partnerVehicleRepository = partnerVehicleRepository;
    }
}
