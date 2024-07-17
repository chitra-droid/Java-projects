package com.example.Vaccino.service;

import com.example.Vaccino.Model.Patient;
import com.example.Vaccino.exception.PatientNotFoundException;
import com.example.Vaccino.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;


    public Patient addPatient(Patient patient) {
     Patient savedPatient = patientRepository.save(patient);
     return savedPatient;
    }

    public Patient getPatient(int id) {
        Optional<Patient> OptionalPatient = patientRepository.findById(id);

        if(OptionalPatient.isEmpty()){
            throw new PatientNotFoundException("Id not found!");
        }
        Patient patient = OptionalPatient.get();
        return patient;
    }
}
