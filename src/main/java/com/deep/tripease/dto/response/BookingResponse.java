package com.deep.tripease.dto.response;

import com.deep.tripease.enums.Tripstatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookingResponse {

    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    private Tripstatus tripstatus;
    private double billAmount;

}
