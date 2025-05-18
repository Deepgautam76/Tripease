package com.deep.tripease.transformer;

import com.deep.tripease.dto.request.CabRequest;
import com.deep.tripease.dto.response.CabResponse;
import com.deep.tripease.model.Cab;

public class CabTransformer {

    public static Cab CabRequestToCab(CabRequest cabRequest){
        return Cab
                .builder()
                .cabName(cabRequest.getCabName())
                .cabModel(cabRequest.getCabModel())
                .parKmRate(cabRequest.getParKmRate())
                .available(cabRequest.isAvailable())
                .build();
    }
    public static CabResponse CabRequestToCab(Cab cab){
        return CabResponse
                .builder()
                .cabId(cab.getCabId())
                .cabName(cab.getCabName())
                .cabModel(cab.getCabModel())
                .parKmRate(cab.getParKmRate())
                .available(cab.isAvailable())
                .build();
    }
}
