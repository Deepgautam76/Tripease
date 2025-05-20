package com.deep.tripease.dto.request;

import com.deep.tripease.enums.Tripstatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingRequest {

    private String pickup;
    private String destination;
    private double tripDistanceInKm;
}
