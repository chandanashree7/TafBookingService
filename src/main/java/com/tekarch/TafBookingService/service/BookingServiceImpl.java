package com.tekarch.TafBookingService.service;

import com.tekarch.TafBookingService.model.BookingRequest;
import com.tekarch.TafBookingService.model.BookingResponse;
import com.tekarch.TafBookingService.model.Flight;
import com.tekarch.TafBookingService.resttemplate.BookingRestTemplate;
import com.tekarch.TafBookingService.service.Interface.BookingServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingServiceInterface {

    @Autowired
    BookingRestTemplate bookingTemplate;


    @Autowired
    private RestTemplate restTemplate;


    @Override
    public BookingResponse createBooking(BookingRequest booking) {
        if(booking!= null) {
            if (booking.getUserId() != null && booking.getUserId() > 0){

            } else if(booking.getFlightId() != null && booking.getFlightId() > 0){

            } else if (booking.getStatus() != null) {

            } else {
                return null;
            }
        }
        return bookingTemplate.createBooking(booking);
    }

    /*@Override
    public BookingRequest updateBooking(Long BookingId, BookingRequest updateBooking) {
        return null;
    }*/

    @Override
    public BookingResponse getBookingById(Long bookingId) {
        return bookingTemplate.getBooking(bookingId);
    }

    @Override
    public List<BookingResponse> getBookingByUserId(Long userId) {
        return bookingTemplate.getBookingByUserId(userId);
    }

    public BookingResponse cancelBooking(Long bookingId) {
        return bookingTemplate.getBooking(bookingId);

    }


}