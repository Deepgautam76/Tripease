package com.deep.tripease.model;

import com.deep.tripease.enums.Tripstatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String pickup;
    private String destination;
    private double tripDistanceInKm;

    @Enumerated(value = EnumType.STRING)
    private Tripstatus tripstatus;
    private double billAmount;

    @CreationTimestamp
    private Date bookedAt;

    @UpdateTimestamp
    private Date lastUpdateAt;
}
