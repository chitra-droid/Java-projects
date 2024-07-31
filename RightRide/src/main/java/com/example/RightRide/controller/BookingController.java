package com.example.RightRide.controller;

import com.example.RightRide.dto.Requests.BookingRequest;
import com.example.RightRide.dto.Responses.BookingResponse;
import com.example.RightRide.service.BookingService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookingController {


    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity makeBooking(@RequestBody BookingRequest bookingRequest){
       try {
           BookingResponse bookingResponse = bookingService.makeBooking(bookingRequest);
           return new ResponseEntity(bookingResponse, HttpStatus.CREATED);
       }catch(Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
}
