package com.example.RightRide.Transformers;

import com.example.RightRide.Entity.Booking;
import com.example.RightRide.Entity.Cab;
import com.example.RightRide.Enum.BookingStatus;
import com.example.RightRide.DTO.Requests.BookingRequest;
import com.example.RightRide.DTO.Responses.BookingResponse;

import java.util.UUID;

public class BookingTransformer {

    public static Booking bookingRequestToBooking(BookingRequest bookingRequest, Cab cab){
        return Booking.builder()
                .bookingId(String.valueOf(UUID.randomUUID()))
                .bookingStatus(BookingStatus.CONFIRMED)
                .pickUp(bookingRequest.getPickUp())
                .destination(bookingRequest.getDestination())
                .totalDistance(bookingRequest.getTotalDistance())
                .build();
    }

    public static BookingResponse bookingToBookingResponse(Booking booking){
        return BookingResponse.builder()
                .bookedAt(booking.getBookedAt())
                .pickUp(booking.getPickUp())
                .destination(booking.getDestination())
                .totalDistance(booking.getTotalDistance())
                .totalFare(booking.getTotalFare())
                .bookingId(booking.getId())
                .bookingStatus(booking.getBookingStatus())
                .customer(CustomerTransformers.customerToCustomerResponse(booking.getCustomer()))
                .driver(DriverTransformers.driverToDriverResponse(booking.getDriver()))
                .build();
    }
}
