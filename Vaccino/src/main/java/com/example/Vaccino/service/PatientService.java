package com.example.Vaccino.service;

import com.example.Vaccino.Model.Patient;
import com.example.Vaccino.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;


    public Patient addPatient(Patient patient) {
     Patient savedPatient = patientRepository.save(patient);
     return savedPatient;
    }
}
