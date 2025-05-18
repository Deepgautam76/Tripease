package com.deep.tripease.transformer;

import com.deep.tripease.dto.request.BookingRequest;
import com.deep.tripease.dto.response.BookingResponse;
import com.deep.tripease.model.Booking;

public class BookingTransformer {
    public static Booking BookingRequestToBooking(BookingRequest bookingRequest){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripstatus(bookingRequest.getTripstatus())
                .tripDistanceInKm(bookingRequest.getTripDistanceInKm())
                .billAmount(bookingRequest.getBillAmount())
                .build();
    }
    public static BookingResponse BookingToBookingResponse(Booking booking){
        return BookingResponse.builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDistanceInKm(booking.getTripDistanceInKm())
                .tripstatus(booking.getTripstatus())
                .billAmount(booking.getBillAmount())
                .build();
    }
}
