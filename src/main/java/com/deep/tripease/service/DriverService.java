package com.deep.tripease.service;

import com.deep.tripease.dto.request.DriverRequest;
import com.deep.tripease.dto.response.DriverResponse;
import com.deep.tripease.model.Driver;
import com.deep.tripease.repository.DriverRepository;
import com.deep.tripease.transformer.DriverTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;
    public ResponseEntity<List<DriverResponse>> findAllDriver(){
        List<Driver> drivers=driverRepository.findAll();
        List<DriverResponse> driverResponseList=new ArrayList<>();
        for (Driver driver:drivers){
            driverResponseList.add(DriverTransformer.DriverToDriverResponse(driver));

        }
        return new ResponseEntity<>(driverResponseList, HttpStatus.OK);
    }

    public ResponseEntity<DriverResponse> addDriver(DriverRequest driverRequest) {
        Driver driver=DriverTransformer.DriverRequestToDriver(driverRequest);
        DriverResponse driverResponse=DriverTransformer.DriverToDriverResponse(driverRepository.save(driver));
        return new ResponseEntity<>(driverResponse,HttpStatus.CREATED);
    }
}
