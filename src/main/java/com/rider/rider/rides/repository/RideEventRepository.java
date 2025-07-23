package com.rider.rider.rides.repository;

import com.rider.rider.rides.entity.RideEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RideEventRepository extends JpaRepository<RideEvent, UUID> {
    List<RideEvent> findAllByRideId(UUID rideId);
}
