package com.deep.tripease.dto.request;

import com.deep.tripease.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DriverRequest {

    private String name;
    private int age;
    private Gender gender;
    private String emailId;

}
