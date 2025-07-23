package com.rider.rider.rides.util.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FareCalculator {
    public static BigDecimal getEstimatedFare() {
        BigDecimal baseFare = new BigDecimal("30.0");           // ₹30
        BigDecimal costPerKm = new BigDecimal("10.0");          // ₹10 per km
        BigDecimal costPerMinute = new BigDecimal("2.0");       // ₹2 per min
        BigDecimal surgeMultiplier = new BigDecimal("1.5");     // 1.5x surge pricing
        BigDecimal serviceFee = new BigDecimal("5.0");          // Optional platform fee

        double distanceInKm = 8.2;      // From pickup to drop
        long durationInMinutes = 18;    // Estimated duration

        BigDecimal distanceFare = costPerKm.multiply(BigDecimal.valueOf(distanceInKm));
        BigDecimal timeFare = costPerMinute.multiply(BigDecimal.valueOf(durationInMinutes));

        BigDecimal estimatedFare = baseFare
                .add(distanceFare)
                .add(timeFare)
                .multiply(surgeMultiplier)
                .add(serviceFee);

        System.out.println("Estimated Fare = ₹" + estimatedFare.setScale(2, RoundingMode.HALF_UP));
//        Estimated Fare =
//                (baseFare + distance * costPerKm + duration * costPerMinute) * surge + serviceFee
        return estimatedFare.setScale(2, RoundingMode.HALF_UP);
    }
}
