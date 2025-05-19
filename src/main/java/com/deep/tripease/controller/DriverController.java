package com.deep.tripease.controller;

import com.deep.tripease.dto.request.DriverRequest;
import com.deep.tripease.dto.response.DriverResponse;
import com.deep.tripease.model.Driver;
import com.deep.tripease.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @GetMapping("/get")
    public ResponseEntity<List<DriverResponse>> getAllDriver(){
        return driverService.findAllDriver();
    }

    @PostMapping("/add")
    public ResponseEntity<DriverResponse> addDriver(@RequestBody DriverRequest driverRequest){
        return driverService.addDriver(driverRequest);
    }



}
