package com.example.RightRide.controller;

import com.example.RightRide.dto.Requests.DriverRequest;
import com.example.RightRide.dto.Responses.DriverResponse;
import com.example.RightRide.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping
    public ResponseEntity addDriverAndCab(@RequestBody DriverRequest driverRequest){
        String s = driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity(s, HttpStatus.CREATED);
    }

    @GetMapping
    public DriverResponse getDriver(@RequestParam("mobile") long mobileNo){
      return driverService.getDriver(mobileNo);
    }
}
