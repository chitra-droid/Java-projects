package com.example.RightRide.Transformers;

import com.example.RightRide.Entity.Driver;
import com.example.RightRide.DTO.Requests.DriverRequest;
import com.example.RightRide.DTO.Responses.DriverResponse;
import com.example.RightRide.Enum.Rating;

public class DriverTransformers {

    public static Driver driverRequestToDriver(DriverRequest driverRequest){
        return Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .mobileNo(driverRequest.getMobileNo())
                .drivingLicense(driverRequest.getDrivingLicense())
                .rating(Rating.ZERO)
                .build();
    }

    public static DriverResponse driverToDriverResponse(Driver driver){
        return DriverResponse.builder()
                .name(driver.getName())
                .mobileNo(driver.getMobileNo())
                .cabResponse(CabTranformers.cabToCabResponse(driver.getCab()))
                .rating(driver.getRating())
                .build();
    }
}
