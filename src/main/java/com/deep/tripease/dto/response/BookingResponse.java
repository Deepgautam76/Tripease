package com.deep.tripease.dto.response;

import com.deep.tripease.enums.Tripstatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    private Date bookedAt;
    private Date lastUpDateAt;

    private CustomerResponse customer;
    private CabResponse cab;

}
