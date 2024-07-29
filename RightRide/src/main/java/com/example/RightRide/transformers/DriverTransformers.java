package com.example.RightRide.transformers;

import com.example.RightRide.Entity.Driver;
import com.example.RightRide.dto.Requests.DriverRequest;
import com.example.RightRide.dto.Responses.DriverResponse;

public class DriverTransformers {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .mobileNo(driverRequest.getMobileNo())
                .drivingLicense(driverRequest.getDrivingLicense())
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .name(driver.getName())
                .mobileNo(driver.getMobileNo())
                .cabResponse(CabTranformers.cabToCabResponse(driver.getCab()))
                .build();
    }
}
