package com.example.Vaccino.service;

import com.example.Vaccino.Enum.AppointmentStatus;
import com.example.Vaccino.Model.Appointment;
import com.example.Vaccino.Model.Doctor;
import com.example.Vaccino.Model.Patient;
import com.example.Vaccino.exception.DoctorNotFoundException;
import com.example.Vaccino.exception.PatientIsVaccinatedException;
import com.example.Vaccino.exception.PatientNotFoundException;
import com.example.Vaccino.repository.AppointmentRepository;
import com.example.Vaccino.repository.DoctorRepository;
import com.example.Vaccino.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;


    public Appointment BookAppointment(int patId, int docId) {

        Optional<Patient> OptionalPat = patientRepository.findById(patId);

        Optional<Doctor> OptionalDoc = doctorRepository.findById(docId);

        if(OptionalPat.isEmpty()){
            throw new PatientNotFoundException("Invalid Patient Id");
        }

        if(OptionalDoc.isEmpty()){
            throw new DoctorNotFoundException("Invalid Doctor Id");
        }

        Patient patient = OptionalPat.get();
        Doctor doctor = OptionalDoc.get();

        if(patient.isVaccinated()){
            throw new PatientIsVaccinatedException("Patient already Vaccinated!");
        }

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setAppointmentStatus(AppointmentStatus.BOOKED);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        return appointmentRepository.save(appointment);
    }
}
