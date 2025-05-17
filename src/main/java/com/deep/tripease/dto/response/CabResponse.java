package com.deep.tripease.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CabResponse {

    private int cabId;
    private String cabName;
    private String cabModel;
    private double parKmRate;
    private boolean available;

}
