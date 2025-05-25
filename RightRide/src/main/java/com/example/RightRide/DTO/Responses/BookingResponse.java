package com.example.RightRide.DTO.Responses;

import com.example.RightRide.Enum.BookingStatus;
import lombok.*;

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
