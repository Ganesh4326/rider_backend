package com.rider.rider.rides.service;

import com.rider.rider.rides.model.Ride;
import com.rider.rider.rides.repository.RideRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {
    public final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public Ride saveRide(Ride ride) {
        return rideRepository.save(ride);
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public Ride getRideById(Long id) {
        return rideRepository.findById(id).orElse(null);
    }

    public void deleteRide(Long id) {
        if (!rideRepository.existsById(id)) {
            throw new RuntimeException("Ride not found with: " + id);
        }
        rideRepository.deleteById(id);
    }

    public Ride updateRide(Long id, Ride ride) {
        Ride existingRide = rideRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Ride not found with: " + id));

        existingRide.setStatus(ride.getStatus());
        return rideRepository.save(existingRide);
    }
}
