package com.rider.rider.partners.repository;

import com.rider.rider.partners.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PartnerRepository extends JpaRepository<Partner, UUID> {
    @Query(value = """
            SELECT p.* FROM partners p
            JOIN locations l ON p.current_location_id = l.location_id
            WHERE
              6371 * acos(
                cos(radians(:lat)) * cos(radians(l.latitude)) *
                cos(radians(l.longitude) - radians(:lng)) +
                sin(radians(:lat)) * sin(radians(l.latitude))
              ) < :radiusInKm
              AND p.partner_current_status = 0
            """, nativeQuery = true)
    List<Partner> findNearbyAvailablePartners(
            @Param("lat") double latitude,
            @Param("lng") double longitude,
            @Param("radiusInKm") double radiusInKm
    );

    @Query("SELECT p FROM Partner p JOIN FETCH p.currentLocation")
    List<Partner> findAllWithLocation();
}
