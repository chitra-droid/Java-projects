package com.example.Vaccino.Controller;


import com.example.Vaccino.Dto.Request.PatientRequest;
import com.example.Vaccino.Dto.Response.PatientResponse;
import com.example.Vaccino.Enum.Gender;
import com.example.Vaccino.Service.PatientService;
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
    public ResponseEntity getPatient(@RequestParam("id") int id){
        try {
            PatientResponse PS = patientService.getPatient(id);
            return new ResponseEntity(PS,HttpStatus.FOUND);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all/{gender}")
    public ResponseEntity getAllPatients(@PathVariable("gender") Gender g){
        try {
            List<PatientResponse> AllPatients = patientService.getAllPatients(g);
            return new ResponseEntity(AllPatients,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/unvaccinated")
    public ResponseEntity getAllUnvaccinatedPatients(){
        try {
            List<PatientResponse> patients = patientService.getAllUnvaccinatedPatients();
            return new ResponseEntity(patients,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
