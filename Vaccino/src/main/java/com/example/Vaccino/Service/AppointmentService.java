package com.example.Vaccino.Service;

import com.example.Vaccino.Dto.Response.AppointmentResponse;
import com.example.Vaccino.Dto.Response.AppointmentUpdateResponse;
import com.example.Vaccino.Dto.Response.PatientResponse;
import com.example.Vaccino.Enum.AppointmentStatus;
import com.example.Vaccino.Model.Appointment;
import com.example.Vaccino.Model.Doctor;
import com.example.Vaccino.Model.Patient;
import com.example.Vaccino.Exception.AppointmentNotFoundException;
import com.example.Vaccino.Exception.DoctorNotFoundException;
import com.example.Vaccino.Exception.PatientIsVaccinatedException;
import com.example.Vaccino.Exception.PatientNotFoundException;
import com.example.Vaccino.Repository.AppointmentRepository;
import com.example.Vaccino.Repository.DoctorRepository;
import com.example.Vaccino.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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


    public AppointmentResponse BookAppointment(int patId, int docId) {

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

        Appointment savedappointment = appointmentRepository.save(appointment);

        AppointmentResponse appointmentResponse = new AppointmentResponse();
        appointmentResponse.setDateOfAppointment(savedappointment.getDateOfAppointment());
        appointmentResponse.setAppointmentStatus(savedappointment.getAppointmentStatus());
        appointmentResponse.setAppointmentId(savedappointment.getAppointmentId());
        appointmentResponse.setDoctorName(savedappointment.getDoctor().getName());

        Patient p = savedappointment.getPatient();
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setVaccinated(p.isVaccinated());
        patientResponse.setEmailId(p.getEmailId());
        patientResponse.setName(p.getName());

        appointmentResponse.setPatientResponse(patientResponse);

        return appointmentResponse;

    }

    public AppointmentUpdateResponse CancelAppointment(int id) {
        List<Appointment> appointments = appointmentRepository.findAll();

        AppointmentUpdateResponse Patientappointment = new AppointmentUpdateResponse();

        for(Appointment app : appointments){
            if(app.getPatient().getId()==id){
                app.setAppointmentStatus(AppointmentStatus.CANCELLED);
                appointmentRepository.delete(app);
                Patientappointment.setAppointmentStatus(app.getAppointmentStatus());
                Patientappointment.setAppointmentId(app.getAppointmentId());
                Patientappointment.setDateOfAppointment(app.getDateOfAppointment());
                Patientappointment.setPatientName(app.getPatient().getName());
            }
        }
        if(Patientappointment.getAppointmentId()==null){
            throw new AppointmentNotFoundException("No appointment exists for this id");
        }
        return Patientappointment;
    }

}
