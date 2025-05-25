package com.example.Vaccino.Dto.Response;

import com.example.Vaccino.Enum.AppointmentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentResponse {

    private String appointmentId;

    private Date dateOfAppointment;

    private AppointmentStatus appointmentStatus;

    private PatientResponse patientResponse;

    private String doctorName;
}
