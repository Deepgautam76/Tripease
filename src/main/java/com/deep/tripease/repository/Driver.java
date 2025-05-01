package com.deep.tripease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Driver extends JpaRepository<Driver,Integer> {
}

