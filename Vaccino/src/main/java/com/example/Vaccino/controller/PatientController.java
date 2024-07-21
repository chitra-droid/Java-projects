package com.example.Vaccino.controller;


import com.example.Vaccino.Dto.Request.PatientRequest;
import com.example.Vaccino.Dto.Response.MalePatientResponse;
import com.example.Vaccino.Dto.Response.PatientResponse;
import com.example.Vaccino.Model.Patient;
import com.example.Vaccino.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity addPatient(@RequestBody PatientRequest patient){

        try {
            PatientResponse patientResponse = patientService.addPatient(patient);
            return new ResponseEntity(patientResponse, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public PatientResponse getPatient(@RequestParam("id") int id){
       return patientService.getPatient(id);
    }

    @GetMapping("/males")
    public ResponseEntity getAllMalePatients(){
        try {
            List<MalePatientResponse> AllMalePatients = patientService.getAllMalePatients();
            return new ResponseEntity(AllMalePatients,HttpStatus.FOUND);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
