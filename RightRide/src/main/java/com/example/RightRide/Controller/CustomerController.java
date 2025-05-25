package com.example.RightRide.controller;


import com.example.RightRide.Entity.Customer;import com.example.RightRide.Enum.Gender;
import com.example.RightRide.dto.Requests.CustomerRequest;
import com.example.RightRide.dto.Responses.CustomerResponse;
import com.example.RightRide.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody
                                      CustomerRequest customerRequest){
        try {
            CustomerResponse response = customerService.addCustomer(customerRequest);
            return new ResponseEntity(response, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity("Bad Request!", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity getCustomer(@RequestParam("email") String emailId){
        try{
           CustomerResponse res = customerService.getCustomer(emailId);
           return new ResponseEntity<>(res,HttpStatus.OK);
        }catch(Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get-greater-than")
    public List<Customer> getAllByGenderandAgeGreaterThan(@RequestParam("gender") String gender,
                                                          @RequestParam("age") int age){
       return customerService.getAllByGenderandAgeGreaterThan(gender,age);
    }


    @GetMapping("age-lesser-than/{age}")
    public ResponseEntity getAllByAgeLesserThan(@PathVariable("age") int age){
        try {
            List<CustomerResponse> CR = customerService.getAllByAgeLesserThan(age);
            return new ResponseEntity(CR,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


}
