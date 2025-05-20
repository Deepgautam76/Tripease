package com.deep.tripease.controller;

import com.deep.tripease.dto.request.CabRequest;
import com.deep.tripease.dto.response.CabResponse;
import com.deep.tripease.model.Cab;
import com.deep.tripease.service.CabService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    private CabService cabService;

    @GetMapping("/get")
    public ResponseEntity<List<CabResponse>> getAllCabs(){
        return cabService.getAllCabs();
    }

    @PostMapping("/add/{driver_id}")
    public ResponseEntity<CabResponse> addCab(@RequestBody CabRequest cabRequest,
                                                   @PathVariable("driver_id")int driverId){
        return cabService.addCab(cabRequest,driverId);
    }

    @PutMapping("/status-update/{cab_id}")
    public ResponseEntity<?> updateCabStatus(@PathVariable("cab_id")int cabId){
        return cabService.cabStatusUpdate(cabId);
    }
}
