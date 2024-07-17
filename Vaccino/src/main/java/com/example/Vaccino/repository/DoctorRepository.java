package com.example.Vaccino.repository;

import com.example.Vaccino.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
