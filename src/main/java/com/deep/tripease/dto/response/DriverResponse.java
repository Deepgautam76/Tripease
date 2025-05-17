package com.deep.tripease.dto.response;

import com.deep.tripease.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DriverResponse {

    private int driverId;
    private String name;
    private int age;
    private Gender gender;
    private String emailId;

}
