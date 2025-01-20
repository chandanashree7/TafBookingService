package com.tekarch.TafBookingService.controller;

import com.tekarch.TafBookingService.model.BookingRequest;
import com.tekarch.TafBookingService.model.BookingResponse;
import com.tekarch.TafBookingService.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookingservice")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;

    @PostMapping(path="/create")
    public ResponseEntity<BookingResponse> createBooking(@RequestBody BookingRequest bookingRequest) {
        BookingResponse BookingResponse = bookingService.createBooking(bookingRequest);
         return new ResponseEntity<>(BookingResponse, HttpStatus.CREATED);
    }

    /*@PutMapping(path="updateBooking/{BookingId}")
    public BookingRequest updateBooking(@PathVariable Long BookingId, @RequestBody BookingRequest updateBooking) {
        return bookingService.updateBooking(BookingId,updateBooking);
    }*/

    @GetMapping(path="/getBooking/{bookingId}")
    public ResponseEntity<BookingResponse> getBookingById(@PathVariable Long bookingId) {
        BookingResponse bookingResponse = bookingService.getBookingById(bookingId);
        return ResponseEntity.status(HttpStatus.OK).body(bookingResponse);
    }

    @GetMapping(path="/getBookingByUserId/{userId}")
    public ResponseEntity< List<BookingResponse>> getBookingByUserId(@PathVariable Long userId) {
        List<BookingResponse> bookingResponse = bookingService.getBookingByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(bookingResponse);
    }

    @DeleteMapping("/cancelBooking/{bookingId}")
    public ResponseEntity<BookingResponse> cancelBooking(@PathVariable Long bookingId) {
        BookingResponse booking = bookingService.cancelBooking(bookingId);
        return ResponseEntity.noContent().build();
    }

}
