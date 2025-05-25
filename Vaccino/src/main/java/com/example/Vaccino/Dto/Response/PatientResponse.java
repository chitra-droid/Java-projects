package com.example.Vaccino.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientResponse {


    private String name;

    private String emailId;

    private boolean vaccinated;
}
