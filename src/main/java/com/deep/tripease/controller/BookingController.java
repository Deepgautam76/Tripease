package com.deep.tripease.controller;

import com.deep.tripease.dto.request.BookingRequest;
import com.deep.tripease.dto.response.BookingResponse;
import com.deep.tripease.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @GetMapping("/get")
    public ResponseEntity<List<BookingResponse>> getAllBookings(){
        return bookingService.getAllBookings();
    }


    @PostMapping("/book/customer/{customer_id}")
    public ResponseEntity<BookingResponse> cabBooking(@RequestBody BookingRequest bookingRequest,
                                                     @PathVariable("customer_id") int customerId){
        return bookingService.cabBooking(bookingRequest,customerId);
    }

}
