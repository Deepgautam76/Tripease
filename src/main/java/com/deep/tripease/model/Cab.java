package com.deep.tripease.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cab {
    @Id
    private int cabId;
    private String cabName;
    private String cabModel;
    private double parKmRate;
    private boolean available;
}
