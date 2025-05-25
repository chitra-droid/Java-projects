package com.example.RightRide.Entity;

import com.example.RightRide.Enum.Rating;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Column(unique = true,nullable = false)
    private int drivingLicense;

    @Column(unique = true,nullable = false)
    private long mobileNo;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    private Cab cab;

    @OneToMany(mappedBy = "driver",cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    @Enumerated(value = EnumType.ORDINAL)
    private Rating rating;
}
