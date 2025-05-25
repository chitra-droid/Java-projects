package com.example.Vaccino.Service;

import com.example.Vaccino.Enum.VaccineBrand;
import com.example.Vaccino.Model.Dose;
import com.example.Vaccino.Model.Patient;
import com.example.Vaccino.Exception.PatientNotFoundException;
import com.example.Vaccino.Repository.DoseRepository;
import com.example.Vaccino.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {

    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PatientRepository patientRepository;

    public Dose addDose(VaccineBrand vaccineBrand, int id) {
        Optional<Patient> PatientEntry = patientRepository.findById(id);

        if(PatientEntry.isEmpty()){
            throw new PatientNotFoundException("Patient not found");
        }
        Patient patient = PatientEntry.get();

        if(patient.isVaccinated()){
            throw new RuntimeException("Patient is already Vaccinated!");
        }
        patient.setVaccinated(true);
        Dose dose = new Dose();
        dose.setVaccineBrand(vaccineBrand);
        dose.setSerialNumber(String.valueOf(UUID.randomUUID()));
        dose.setPatient(patient);

        patientRepository.save(patient);
        return doseRepository.save(dose);
    }
}
