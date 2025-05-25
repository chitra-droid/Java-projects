package com.example.RightRide.Controller;

import com.example.RightRide.Entity.Driver;
import com.example.RightRide.DTO.Requests.DriverRequest;
import com.example.RightRide.DTO.Responses.DriverResponse;
import com.example.RightRide.Service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/driver")
@RequiredArgsConstructor
public class DriverController {


    private final DriverService driverService;

    @PostMapping
    public ResponseEntity addDriverAndCab(@RequestBody DriverRequest driverRequest){
        String s = driverService.addDriverAndCab(driverRequest);
        return new ResponseEntity(s, HttpStatus.CREATED);
    }

    @GetMapping
    public DriverResponse getDriver(@RequestParam("mobile") long mobileNo){

        return driverService.getDriver(mobileNo);
    }

    @GetMapping("/get-by-rating-greater-than/{rating}")
    public List<DriverResponse> fetchDriverByRating(@PathVariable("rating") String r){
           return driverService.fetchDriverByRating(r);
    }



}
