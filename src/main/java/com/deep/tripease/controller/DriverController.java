package com.deep.tripease.controller;

import com.deep.tripease.model.Driver;
import com.deep.tripease.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/")
    public List<Driver> getDriver(){
        return driverService.findAllDriver();
    }


}
