package com.example.Vaccino.Dto.Response;

import com.example.Vaccino.Enum.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MalePatientResponse {

    private String name;

    private int age;

    private Gender gender;

    private boolean vaccinated;

}
