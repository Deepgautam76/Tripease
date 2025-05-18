package com.deep.tripease.transformer;

import com.deep.tripease.dto.request.DriverRequest;
import com.deep.tripease.dto.response.DriverResponse;
import com.deep.tripease.model.Driver;

public class DriverTransformer {
    public static Driver DriverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .gender(driverRequest.getGender())
                .emailId(driverRequest.getEmailId())
                .build();
    }

    public static DriverResponse DriverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .driverId(driver.getDriverId())
                .name(driver.getName())
                .age(driver.getAge())
                .gender(driver.getGender())
                .emailId(driver.getEmailId())
                .build();
    }

}
