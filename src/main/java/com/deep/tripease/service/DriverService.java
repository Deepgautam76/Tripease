package com.deep.tripease.service;

import com.deep.tripease.model.Driver;
import com.deep.tripease.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;
    public List<Driver> findAllDriver(){
        return driverRepository.findAll();
    }

}
