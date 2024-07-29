package com.example.RightRide.Entity;

import com.example.RightRide.Enum.BookingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int bookingId;

    private String pickUp;

    private String destination;

    private double totalDistance;

    private double totalFare;

    @CreationTimestamp
    private Date bookedAt;

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Driver driver;


}
