package com.deep.tripease.transformer;

import com.deep.tripease.dto.request.CabRequest;
import com.deep.tripease.dto.response.CabResponse;
import com.deep.tripease.model.Cab;
import com.deep.tripease.model.Driver;

public class CabTransformer {

    public static Cab CabRequestToCab(CabRequest cabRequest){
        return Cab
                .builder()
                .cabName(cabRequest.getCabName())
                .cabModel(cabRequest.getCabModel())
                .parKmRate(cabRequest.getParKmRate())
                .available(true)
                .build();
    }
    public static CabResponse CabToCabResponse(Cab cab,Driver driver){
        return CabResponse
                .builder()
                .cabName(cab.getCabName())
                .cabModel(cab.getCabModel())
                .parKmRate(cab.getParKmRate())
                .available(cab.isAvailable())
                .driver(DriverTransformer.DriverToDriverResponse(driver))
                .build();
    }
}
