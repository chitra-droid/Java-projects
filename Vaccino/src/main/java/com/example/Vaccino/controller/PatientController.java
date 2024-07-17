package com.example.Vaccino.controller;


import com.example.Vaccino.Model.Patient;
import com.example.Vaccino.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public String addPatient(@RequestBody Patient patient){

        try {
            patientService.addPatient(patient);
            return "Patient registered successfully!";
        }
        catch(Exception e){
            return "Incorrect request!";
        }
    }

    @GetMapping("/get")
    public Patient getPatient(@RequestParam("id") int id){
       return patientService.getPatient(id);
    }
}
