package com.deep.tripease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cab extends JpaRepository<Cab,Integer> {
}
