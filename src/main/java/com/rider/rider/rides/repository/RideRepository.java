package com.rider.rider.rides.repository;

import com.rider.rider.rides.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RideRepository extends JpaRepository<Ride, UUID> {
}


// when you want to create custom queries

//public interface RideRepositoryCustom {
//    List<Ride> findRidesWithDistanceGreaterThan(double distance);
//}
//@Repository
//public class RideRepositoryImpl implements RideRepositoryCustom {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Ride> findRidesWithDistanceGreaterThan(double distance) {
//        String jpql = "SELECT r FROM Ride r WHERE r.distance > :distance";
//        return entityManager.createQuery(jpql, Ride.class)
//                .setParameter("distance", distance)
//                .getResultList();
//    }
//@Query("Select u from User u where u.username =: username")
//User findUserByName(@Param("username") String username);
//}
//public interface RideRepository extends JpaRepository<Ride, Long>, RideRepositoryCustom {
//    // standard + custom methods available here
//}
