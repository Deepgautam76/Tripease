package com.deep.tripease.model;

import com.deep.tripease.Enums.Gender;
import com.deep.tripease.model.Booking;
import com.deep.tripease.model.Cab;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Driver {
    @Id
    private int driverId;
    private String name;
    private int age;
    private Gender gender;
    private String emailId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private List<Booking> bookings=new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_id")
    private Cab cab;
}
