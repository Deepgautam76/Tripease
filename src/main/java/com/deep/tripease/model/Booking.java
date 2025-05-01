package com.deep.tripease.model;

import com.deep.tripease.Enums.Tripstatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Booking {
    @Id
    private int bookingId;
    private String pickup;
    private String destination;
    private double tripDistanceInKm;
    private Tripstatus tripstatus;
    private double billAmount;

    @CreationTimestamp
    private Date bookedAt;

    @UpdateTimestamp
    private Date lastUpdateAt;
}
