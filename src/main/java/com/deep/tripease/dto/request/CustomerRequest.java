package com.deep.tripease.dto.request;

import com.deep.tripease.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    private String name;
    private int age;
    private String emailId;
    private Gender gender;

}
