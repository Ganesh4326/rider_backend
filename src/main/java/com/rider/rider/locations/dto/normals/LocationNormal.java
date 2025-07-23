package com.rider.rider.locations.dto.normals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationNormal {
    private String locationId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String address;
    private String name;
    private Double latitude;
    private Double longitude;
    private String city;
    private String state;
    private String country;
    private String postalCode;
}
