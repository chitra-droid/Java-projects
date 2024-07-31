package com.example.RightRide.service;

import com.example.RightRide.Entity.Cab;
import com.example.RightRide.Entity.Driver;
import com.example.RightRide.dto.Requests.DriverRequest;
import com.example.RightRide.dto.Responses.DriverResponse;
import com.example.RightRide.repository.DriverRepository;
import com.example.RightRide.transformers.CabTranformers;
import com.example.RightRide.transformers.DriverTransformers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DriverService {


    private final DriverRepository driverRepository;

    public String addDriverAndCab(DriverRequest driverRequest) {
        Driver driver = DriverTransformers.driverRequestToDriver(driverRequest);
        Cab cab = CabTranformers.cabRequestToCab(driverRequest.getCabRequest());

        driver.setCab(cab);
        cab.setDriver(driver);

        driverRepository.save(driver);

        return "Driver and cab registered successfully!";

    }

    public DriverResponse getDriver(long mobileNo) {
        Driver savedDriver = driverRepository.findByMobileNo(mobileNo);
        return DriverTransformers.driverToDriverResponse(savedDriver);
    }
}
