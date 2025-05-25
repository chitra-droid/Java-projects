package com.example.RightRide.Service;

import com.example.RightRide.Entity.*;
import com.example.RightRide.DTO.Requests.BookingRequest;
import com.example.RightRide.DTO.Responses.BookingResponse;
import com.example.RightRide.Exception.NoCabAvailableException;
import com.example.RightRide.Exception.NoSuchEmailFound;
import com.example.RightRide.Repository.*;
import com.example.RightRide.Transformers.BookingTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingService {


    private final BookingRepository bookingRepository;

    private final CustomerRepository customerRepository;

    private final CabRepository cabRepository;

    private final DriverRepository driverRepository;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    CouponRepository CR;

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

        List<Coupon> CL = CR.findAll();
        Double maxDisc = 0.0;

        for(Coupon c : CL){
            if(c.getPercentageDiscount() > maxDisc){
                maxDisc = (double) c.getPercentageDiscount();
            }
        }

        Booking booking = BookingTransformer.bookingRequestToBooking(bookingRequest,newCab);

        Double Fare = newCab.getFarePerKm()*bookingRequest.getTotalDistance();
        if(maxDisc!=0.0){
            Fare = Fare*(100-maxDisc)/100;
        }
        booking.setTotalFare(Fare);

        Driver driver =  newCab.getDriver();
        Customer customer1 = customer.get();

        booking.setCustomer(customer1);
        booking.setDriver(driver);
        Booking savedBooking = bookingRepository.save(booking);

        customer1.getBookings().add(savedBooking);
        driver.getBookings().add(savedBooking);

        customerRepository.save(customer1);
        driverRepository.save(driver);

        sendEmail(savedBooking);

        return BookingTransformer.bookingToBookingResponse(savedBooking);

    }

    private void sendEmail(Booking savedBooking) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("chitracharan9460@gmail.com");
        simpleMailMessage.setTo(savedBooking.getCustomer().getEmailId());
        simpleMailMessage.setSubject("Booking Confirmed !!");
        simpleMailMessage.setText("Congratulations "+savedBooking.getCustomer().getName()+" ,\nYour ride is booked on "
                +savedBooking.getBookedAt()+" from "+savedBooking.getPickUp()+" to "+savedBooking.getDestination()+
                " .\nHave a pleasent journey!!");
        javaMailSender.send(simpleMailMessage);
    }
}
