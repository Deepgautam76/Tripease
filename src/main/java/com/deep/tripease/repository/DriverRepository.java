package com.deep.tripease.repository;

import com.deep.tripease.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {

    Optional<Driver> findById(int driverId);

    @Query(value = "Select * from driver where driver.cab_id=:cabId",nativeQuery = true)
    Driver findDriverByCabId(@Param("cabId") int cabId);

}

