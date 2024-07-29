package com.example.RightRide.Entity;

import com.example.RightRide.Enum.CabType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Cab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private String cabNumber;

    @Enumerated(value = EnumType.STRING)
    private CabType cabType;

    private double farePerKm;

    private boolean booked;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Driver driver;

}
