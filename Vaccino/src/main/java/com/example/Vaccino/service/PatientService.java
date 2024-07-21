package com.example.Vaccino.service;

import com.example.Vaccino.Dto.Request.PatientRequest;
import com.example.Vaccino.Dto.Response.MalePatientResponse;
import com.example.Vaccino.Dto.Response.PatientResponse;
import com.example.Vaccino.Enum.Gender;
import com.example.Vaccino.Model.Patient;
import com.example.Vaccino.exception.NoMalePatientFoundException;
import com.example.Vaccino.exception.PatientNotFoundException;
import com.example.Vaccino.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<MalePatientResponse> getAllMalePatients() {
        List<Patient> patients = patientRepository.findAll();

        List<MalePatientResponse> malePatientResponses = new ArrayList<>();

        for(Patient p : patients){
            if(p.getGender()==Gender.MALE){
               MalePatientResponse maleP = new MalePatientResponse();
               maleP.setAge(p.getAge());
               maleP.setName(p.getName());
               maleP.setVaccinated(p.isVaccinated());
               maleP.setGender(p.getGender());
               malePatientResponses.add(maleP);
            }
        }
        if(malePatientResponses.isEmpty()){
            throw new NoMalePatientFoundException("No Male Patient Reported!");
        }
        return malePatientResponses;
    }
}
