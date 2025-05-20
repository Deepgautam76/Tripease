package com.deep.tripease.service;

import com.deep.tripease.dto.request.CabRequest;
import com.deep.tripease.dto.response.CabResponse;
import com.deep.tripease.exception.CabNotFoundException;
import com.deep.tripease.exception.DriverNotFoundException;
import com.deep.tripease.model.Cab;
import com.deep.tripease.model.Driver;
import com.deep.tripease.repository.CabRepository;
import com.deep.tripease.repository.DriverRepository;
import com.deep.tripease.transformer.CabTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CabService {

    @Autowired
    private CabRepository cabRepository;

    @Autowired
    private DriverRepository driverRepository;


    // Fetch all cabs from Db
    public ResponseEntity<List<CabResponse>> getAllCabs() {
        List<Cab> cabList=cabRepository.findAll();
        List<Driver> driverList=new ArrayList<>();
        //Find all the driver by cab id
        for(Cab cab:cabList){
            driverList.add(driverRepository.findDriverByCabId(cab.getCabId()));
        }

        //Convert into cab responses
        List<CabResponse>  responseList=new ArrayList<>();
        for (int i=0; i<cabList.size(); i++){
            responseList.add(CabTransformer.CabToCabResponse(cabList.get(i),driverList.get(i)));
        }
        return new ResponseEntity<>(responseList,HttpStatus.OK);
    }

    // Add a new cab in db
    public ResponseEntity<CabResponse> addCab(CabRequest cabRequest,int driverId) {

        //Check the driver
        Optional<Driver> getDriver=driverRepository.findById(driverId);
        if(getDriver.isEmpty()){
            throw new DriverNotFoundException("Invalid driver not found !");
        }
        Driver driver=getDriver.get();
        Cab cab= CabTransformer.CabRequestToCab(cabRequest);
        driver.setCab(cab);
        Driver savedDriver=driverRepository.save(driver);

        // Final response sends it to user
        CabResponse cabResponse=CabTransformer.CabToCabResponse(savedDriver.getCab(),savedDriver);

        return new ResponseEntity<>(cabResponse,HttpStatus.CREATED);
    }

    // Update cabStatus Unavailable to available
    public ResponseEntity<?> cabStatusUpdate(int cabId) {
        Optional<Cab> optionalCab=cabRepository.findById(cabId);
        if(optionalCab.isEmpty()){
            throw new CabNotFoundException("This is invalid cabId");
        }

        Cab cab=optionalCab.get();
        cab.setAvailable(!cab.isAvailable());
        cabRepository.save(cab);
        return new ResponseEntity<>("Cab updated successfully of id "+cabId,HttpStatus.ACCEPTED);
    }

}
