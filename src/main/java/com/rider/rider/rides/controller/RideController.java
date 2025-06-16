package com.rider.rider.rides.controller;

import com.rider.rider.rides.model.Ride;
import com.rider.rider.rides.service.RideService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {
    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @GetMapping("/all")
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    @PostMapping("/create")
    public Ride saveRide(@RequestBody Ride ride) {
        return rideService.saveRide(ride);
    }

    @GetMapping("/{id}")
    public Ride getRideById(@PathVariable Long id) {
        return rideService.getRideById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRide(@PathVariable Long id) {
        rideService.deleteRide(id);
    }

    @PutMapping("/update/{id}")
    public Ride updateRide(@PathVariable Long id, @RequestBody Ride ride) {
        return rideService.updateRide(id, ride);
    }
}
