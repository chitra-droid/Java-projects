package com.example.Vaccino.controller;


import com.example.Vaccino.Model.Patient;
import com.example.Vaccino.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody Patient patient){

        try {
            patientService.addPatient(patient);
            return new ResponseEntity("Patient registered successfully!", HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public Patient getPatient(@RequestParam("id") int id){
       return patientService.getPatient(id);
    }
}
