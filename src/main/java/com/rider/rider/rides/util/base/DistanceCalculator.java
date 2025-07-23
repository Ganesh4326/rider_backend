package com.rider.rider.rides.util.base;

//To calculate the distance between two locations using
// their latitude and longitude, you can use the Haversine formula,
// which calculates the great-circle distance (shortest distance over the Earth’s surface).

public class DistanceCalculator {

    private static final int EARTH_RADIUS_KM = 6371; // Radius of Earth in kilometers

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convert degrees to radians
        System.out.println("LL:" + lat1 + "->" + lat2+ "->" + lon1+ "->" + lon2);
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Apply Haversine formula
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }

    public static void main(String[] args) {
        double lat1 = 17.387592171764222, lon1 = 78.35734416906432;
        double lat2 = 17.395741957724876, lon2 = 78.37185310474479;

        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.printf("Distance: %.2f km%n", distance);
    }
}
