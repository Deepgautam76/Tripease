package com.deep.tripease.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CabRequest {

    private String cabName;
    private String cabModel;
    private double parKmRate;
}
