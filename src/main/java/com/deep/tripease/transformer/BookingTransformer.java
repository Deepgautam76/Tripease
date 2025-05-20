package com.deep.tripease.transformer;

import com.deep.tripease.dto.request.BookingRequest;
import com.deep.tripease.dto.response.BookingResponse;
import com.deep.tripease.enums.Tripstatus;
import com.deep.tripease.model.Booking;
import com.deep.tripease.model.Cab;
import com.deep.tripease.model.Customer;
import com.deep.tripease.model.Driver;
import lombok.Data;

public class BookingTransformer {
    public static Booking BookingRequestToBooking(BookingRequest bookingRequest,double cabPerKmRate){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDistanceInKm(bookingRequest.getTripDistanceInKm())
                .tripstatus(Tripstatus.ONGOING)
                .billAmount(bookingRequest.getTripDistanceInKm()*cabPerKmRate)
                .build();
    }
    public static BookingResponse BookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver){
        return BookingResponse.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDistanceInKm(booking.getTripDistanceInKm())
                .tripstatus(booking.getTripstatus())
                .billAmount(booking.getBillAmount())
                .bookedAt(booking.getBookedAt())
                .lastUpDateAt(booking.getLastUpdateAt())
                .customer(CustomerTransformer.CustomerToCustomerResponse(customer))
                .cab(CabTransformer.CabToCabResponse(cab,driver))
                .build();
    }
}
