package com.rider.rider.rides.repository;

import com.rider.rider.rides.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {
}
