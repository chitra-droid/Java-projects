package com.example.Vaccino.repository;

import com.example.Vaccino.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
