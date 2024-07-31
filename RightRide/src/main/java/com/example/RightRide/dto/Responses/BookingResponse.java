package com.example.RightRide.dto.Responses;

import com.example.RightRide.Entity.Customer;
import com.example.RightRide.Entity.Driver;
import com.example.RightRide.Enum.BookingStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {

    private int bookingId;

    private String pickUp;

    private String destination;

    private double totalDistance;

    private double totalFare;

    private Date bookedAt;

    private BookingStatus bookingStatus;

    private CustomerResponse customer;

    private DriverResponse driver;
}
