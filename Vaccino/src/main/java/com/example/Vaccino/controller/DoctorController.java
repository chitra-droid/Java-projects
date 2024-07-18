package com.example.Vaccino.controller;

import com.example.Vaccino.Enum.Specialization;
import com.example.Vaccino.Model.Doctor;
import com.example.Vaccino.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get")
    public Doctor getDoctor(@RequestParam int id){
       return doctorService.getDoctor(id);
    }

    @GetMapping("/getBySpecialization")
    public List<Doctor> getDoctor(@RequestParam Specialization specialization){
        return doctorService.getDoctor(specialization);
    }
}
