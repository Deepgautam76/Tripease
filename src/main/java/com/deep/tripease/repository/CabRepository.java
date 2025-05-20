package com.deep.tripease.repository;

import com.deep.tripease.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepository extends JpaRepository<Cab,Integer> {
    @Query("Select c from Cab c where c.available=true order by RAND() LIMIT 1")
    Cab findAvailableCabRandom();
}
