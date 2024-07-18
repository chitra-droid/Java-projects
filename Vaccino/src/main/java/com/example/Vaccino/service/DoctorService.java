package com.example.Vaccino.service;

import com.example.Vaccino.Enum.Specialization;
import com.example.Vaccino.Model.Doctor;
import com.example.Vaccino.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {

        Doctor savedDoc = doctorRepository.save(doctor);
        return savedDoc;
    }


    public Doctor getDoctor(int id) {
        Optional<Doctor> OptionalDoc =  doctorRepository.findById(id);
        if(OptionalDoc.isEmpty()){
            throw new RuntimeException("Invalid Id");
        }
        Doctor doc = OptionalDoc.get();
        return doc;
    }

    public List<Doctor> getDoctor(Specialization specialization) {
        List<Doctor> Doctors = doctorRepository.findAll();

        List<Doctor> res = new ArrayList<>();

        for(Doctor doc : Doctors){
            if(doc.getSpecialization().equals(specialization)){
                res.add(doc);
            }
        }
        if(res.size()==0){
            throw new RuntimeException("Doctor not found");
        }

        return res;

    }
}
