package com.example.Vaccino.service;

import com.example.Vaccino.Model.Doctor;
import com.example.Vaccino.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {

        Doctor savedDoc = doctorRepository.save(doctor);
        return savedDoc;
    }
}
