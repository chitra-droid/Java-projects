package com.example.Vaccino.Repository;

import com.example.Vaccino.Model.Dose;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoseRepository extends JpaRepository<Dose,Integer> {
}
