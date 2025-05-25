package com.example.Vaccino.Dto.Request;

import com.example.Vaccino.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientRequest {

    private String name;

    private int age;

    private Gender gender;

    private String emailId;

}
