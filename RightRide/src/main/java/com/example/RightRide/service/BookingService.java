package com.example.RightRide.service;

import com.example.RightRide.Entity.Booking;
import com.example.RightRide.Entity.Cab;
import com.example.RightRide.Entity.Customer;
import com.example.RightRide.Entity.Driver;
import com.example.RightRide.dto.Requests.BookingRequest;
import com.example.RightRide.dto.Responses.BookingResponse;
import com.example.RightRide.exception.NoCabAvailableException;
import com.example.RightRide.exception.NoSuchEmailFound;
import com.example.RightRide.repository.BookingRepository;
import com.example.RightRide.repository.CabRepository;
import com.example.RightRide.repository.CustomerRepository;
import com.example.RightRide.repository.DriverRepository;
import com.example.RightRide.transformers.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {


    private final BookingRepository bookingRepository;

    private final CustomerRepository customerRepository;

    private final CabRepository cabRepository;

    private final DriverRepository driverRepository;


    public BookingResponse makeBooking(BookingRequest bookingRequest) {
        Optional<Customer> customer = customerRepository.
                findByEmailId(bookingRequest.getCustomerEmail());

        if(customer.isEmpty()){
            throw new NoSuchEmailFound("Unauthorised Customer!");
        }

        Optional<Cab> cab = cabRepository.findAvailableCab();
        if(cab.isEmpty()){
            throw new NoCabAvailableException("OOPS, All cabs are busy at the moment!");
        }
        Cab newCab = cab.get();
        newCab.setBooked(true);
        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest,newCab);

        Driver driver =  newCab.getDriver();
        Customer customer1 = customer.get();

        booking.setCustomer(customer1);
        booking.setDriver(driver);
        Booking savedBooking = bookingRepository.save(booking);

        customer1.getBookings().add(savedBooking);
        driver.getBookings().add(savedBooking);

        customerRepository.save(customer1);
        driverRepository.save(driver);

        return BookingTransformer.bookingToBookingResponse(savedBooking);

    }
}
