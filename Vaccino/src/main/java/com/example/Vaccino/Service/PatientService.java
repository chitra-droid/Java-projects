package com.example.Vaccino.Service;

import com.example.Vaccino.Dto.Request.PatientRequest;
import com.example.Vaccino.Dto.Response.PatientResponse;
import com.example.Vaccino.Enum.Gender;
import com.example.Vaccino.Exception.NoPatientFoundException;
import com.example.Vaccino.Model.Patient;
import com.example.Vaccino.Exception.PatientNotFoundException;
import com.example.Vaccino.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;


    public PatientResponse addPatient(PatientRequest patientRequest) {

        Patient patient = new Patient();
        patient.setVaccinated(false);
        patient.setAge(patientRequest.getAge());
        patient.setName(patientRequest.getName());
        patient.setGender(patientRequest.getGender());
        patient.setEmailId(patientRequest.getEmailId());


     Patient savedPatient = patientRepository.save(patient);

     PatientResponse patientResponse = new PatientResponse();
     patientResponse.setName(savedPatient.getName());
     patientResponse.setVaccinated(savedPatient.isVaccinated());
     patientResponse.setEmailId(savedPatient.getEmailId());

     return patientResponse;
    }

    public PatientResponse getPatient(int id) {
        Optional<Patient> OptionalPatient = patientRepository.findById(id);

        if(OptionalPatient.isEmpty()){
            throw new PatientNotFoundException("Id not found!");
        }
        Patient patient = OptionalPatient.get();
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setEmailId(patient.getEmailId());
        patientResponse.setName(patient.getName());
        patientResponse.setVaccinated(patient.isVaccinated());
        return patientResponse;
    }

    public List<PatientResponse> getAllPatients(Gender g) {
        List<Patient> patients = patientRepository.findAll();

        List<PatientResponse> PatientResponses = new ArrayList<>();

        for(Patient p : patients){
            if(p.getGender()==g){
               PatientResponse P = new  PatientResponse();

               P.setName(p.getName());
               P.setVaccinated(p.isVaccinated());
               PatientResponses.add(P);
            }
        }
        if(PatientResponses.isEmpty()){
            throw new NoPatientFoundException("No "+g+" Patient Reported!");
        }
        return PatientResponses;
    }

    public List<PatientResponse> getAllUnvaccinatedPatients() {
        List<Patient> savedPatients = patientRepository.findAll();
        List<PatientResponse> PR = new ArrayList<>();
        for(Patient p : savedPatients){
            if(!p.isVaccinated()){
                PatientResponse patientResponse = new PatientResponse();
                patientResponse.setName(p.getName());
                patientResponse.setVaccinated(p.isVaccinated());
                patientResponse.setEmailId(p.getEmailId());
                PR.add(patientResponse);
            }
        }
        if(PR.size()==0){
            throw new RuntimeException("No Unvaccinated Patient found");
        }
        return PR;
    }
}
