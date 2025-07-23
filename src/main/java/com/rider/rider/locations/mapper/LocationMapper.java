package com.rider.rider.locations.mapper;

import com.rider.rider.locations.dto.normals.LocationNormal;
import com.rider.rider.locations.entity.Location;

import java.util.UUID;

public class LocationMapper {
    public static LocationNormal toNormal(Location location) {
        LocationNormal locationNormal = new LocationNormal();
        locationNormal.setLocationId(location.getId().toString());
        locationNormal.setCreatedAt(location.getCreatedAt());
        locationNormal.setUpdatedAt(location.getUpdatedAt());
        locationNormal.setLatitude(location.getLatitude());
        locationNormal.setLongitude(location.getLongitude());
        locationNormal.setAddress(location.getAddress());
        locationNormal.setName(location.getName());
        locationNormal.setCity(location.getCity());
        locationNormal.setState(location.getState());
        locationNormal.setCountry(location.getCountry());
        locationNormal.setCountry(location.getCountry());
        locationNormal.setPostalCode(location.getPostalCode());
        return locationNormal;
    }

    public static Location toEntity(LocationNormal locationNormal) {
        System.out.println("Location normal: " + locationNormal);
        Location location = new Location();
        location.setId(UUID.fromString(locationNormal.getLocationId()));
        location.setCreatedAt(locationNormal.getCreatedAt());
        location.setUpdatedAt(locationNormal.getUpdatedAt());
        location.setLatitude(locationNormal.getLatitude());
        location.setLongitude(locationNormal.getLongitude());
        location.setAddress(locationNormal.getAddress());
        location.setName(locationNormal.getName());
        location.setCity(locationNormal.getCity());
        location.setState(locationNormal.getState());
        location.setCountry(locationNormal.getCountry());
        location.setCountry(locationNormal.getCountry());
        location.setPostalCode(locationNormal.getPostalCode());
        return location;
    }
}
