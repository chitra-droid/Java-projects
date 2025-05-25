package com.example.Vaccino.Model;

import com.example.Vaccino.Enum.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String appointmentId;

    @CreationTimestamp
    private Date dateOfAppointment;

    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus appointmentStatus;

    @OneToOne
    @JoinColumn
    Patient patient;

    @ManyToOne
    @JoinColumn
    Doctor doctor;

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", appointmentId='" + appointmentId + '\'' +
                ", dateOfAppointment=" + dateOfAppointment +
                ", appointmentStatus=" + appointmentStatus +
                ", patient=" + patient +
                ", doctor=" + doctor +
                '}';
    }
}
