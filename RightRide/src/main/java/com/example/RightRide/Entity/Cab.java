package com.example.RightRide.Entity;

import com.example.RightRide.Enum.CabType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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
    private Driver driver;

}
