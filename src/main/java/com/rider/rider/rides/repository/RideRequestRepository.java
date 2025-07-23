package com.rider.rider.rides.repository;

import com.rider.rider.rides.entity.RideRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RideRequestRepository extends JpaRepository<RideRequest, UUID> {
}
