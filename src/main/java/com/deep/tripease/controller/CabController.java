package com.deep.tripease.controller;

import com.deep.tripease.dto.request.CabRequest;
import com.deep.tripease.dto.response.CabResponse;
import com.deep.tripease.model.Cab;
import com.deep.tripease.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return null;
    }

    @PostMapping("/add/{driver_id}")
    public ResponseEntity<CabResponse> addCab(@RequestBody CabRequest cabRequest,
                                                   @PathVariable("driver_id")int driverId){
        return cabService.addCab(cabRequest,driverId);
    }
}
