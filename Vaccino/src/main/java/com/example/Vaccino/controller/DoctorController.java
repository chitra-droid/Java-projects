package com.example.Vaccino.controller;

import com.example.Vaccino.Model.Doctor;
import com.example.Vaccino.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/add")
    public String addDoctor(@RequestBody Doctor doctor){
        try {
            doctorService.addDoctor(doctor);
           return "Doctor registered successfully!";
        }
        catch (Exception e){
           return "Invalid Doctor request!";
        }
    }
}
