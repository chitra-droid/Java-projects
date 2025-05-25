package com.example.RightRide.Service;

import com.example.RightRide.Entity.Cab;
import com.example.RightRide.Entity.Driver;
import com.example.RightRide.DTO.Requests.DriverRequest;
import com.example.RightRide.DTO.Responses.DriverResponse;
import com.example.RightRide.Enum.Rating;
import com.example.RightRide.Repository.DriverRepository;
import com.example.RightRide.Transformers.CabTranformers;
import com.example.RightRide.Transformers.DriverTransformers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<DriverResponse> fetchDriverByRating(String r) {
        List<Driver> driverList = driverRepository.findAll();
        List<DriverResponse> Drivers = new ArrayList<>();
        for(Driver dri : driverList){
            if(dri.getRating().equals(r)){
                DriverResponse DR = DriverTransformers.driverToDriverResponse(dri);
                Drivers.add(DR);
            }
        }
        return Drivers;
    }
}
