package com.tekarch.TafBookingService.service.Interface;

import com.tekarch.TafBookingService.model.BookingRequest;
import com.tekarch.TafBookingService.model.BookingResponse;

import java.util.List;

public interface BookingServiceInterface {

    BookingResponse createBooking(BookingRequest requestBooking);
    //BookingRequest updateBooking(Long BookingId, BookingRequest updateBooking);
    BookingResponse getBookingById(Long bookingId);
    List<BookingResponse> getBookingByUserId(Long userId);
    BookingResponse cancelBooking(Long bookingId);
}
