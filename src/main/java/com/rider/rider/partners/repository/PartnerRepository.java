package com.rider.rider.partners.repository;

import com.rider.rider.partners.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PartnerRepository extends JpaRepository<Partner, UUID> {
}
