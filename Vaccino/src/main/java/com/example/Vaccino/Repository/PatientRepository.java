package com.example.Vaccino.Repository;

import com.example.Vaccino.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
