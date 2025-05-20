package com.deep.tripease.service;

import com.deep.tripease.dto.request.BookingRequest;
import com.deep.tripease.dto.response.BookingResponse;
import com.deep.tripease.exception.CabNotAvailableException;
import com.deep.tripease.exception.CustomerNotFoundException;
import com.deep.tripease.model.Booking;
import com.deep.tripease.model.Cab;
import com.deep.tripease.model.Customer;
import com.deep.tripease.model.Driver;
import com.deep.tripease.repository.BookingRepository;
import com.deep.tripease.repository.CabRepository;
import com.deep.tripease.repository.CustomerRepository;
import com.deep.tripease.repository.DriverRepository;
import com.deep.tripease.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CabRepository cabRepository;
    @Autowired
    private DriverRepository driverRepository;


    public ResponseEntity<BookingResponse> cabBooking(BookingRequest bookingRequest, int customerId) {

        // Check the customer
        Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Invalid customer id");
        }
        Customer customer=optionalCustomer.get();

        // Select the random Cab
        Cab availableCab=cabRepository.findAvailableCabRandom();
        if(availableCab==null){
            throw new CabNotAvailableException("Sorry cab not available try some time latter");

        }

        // Here all changes set
        Booking booking= BookingTransformer.BookingRequestToBooking(bookingRequest,availableCab.getParKmRate());
        // First save the booking in booking table than save in all parent tables
        Booking savedBooking=bookingRepository.save(booking);
        availableCab.setAvailable(false);
        // Add booking in Customer table
        customer.getBookings().add(savedBooking);

        // Get the driver by cabId
        Driver driver=driverRepository.findDriverByCabId(availableCab.getCabId());
        // Add booking in driver table
        driver.getBookings().add(savedBooking);

        //Save all tables that modify by booking
        Driver savedDriver=driverRepository.save(driver);
        Customer savedCustomer=customerRepository.save(customer);

        BookingResponse finalBookingResponse=BookingTransformer.BookingToBookingResponse(savedBooking,savedCustomer,availableCab,savedDriver);
        return new ResponseEntity<>(finalBookingResponse,HttpStatus.CREATED);
    }

    public ResponseEntity<?> getAllBookings() {
        List<Booking> booking=bookingRepository.findAll();
       return new ResponseEntity<>(booking,HttpStatus.OK);
    }
}
