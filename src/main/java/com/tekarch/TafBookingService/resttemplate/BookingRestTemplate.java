package com.tekarch.TafBookingService.resttemplate;

import com.tekarch.TafBookingService.model.BookingRequest;
import com.tekarch.TafBookingService.model.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.Arrays;
import java.util.List;

@Component
public class BookingRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL="http://localhost:8083/api";

    public BookingResponse createBooking(BookingRequest requestBooking){
        String url=BASE_URL+ "/bookings";
        BookingResponse response =  restTemplate.postForObject(url,requestBooking, BookingResponse.class);
        System.out.println("Booking response:"+response);
        return response;
    }

    public BookingResponse getBooking(Long bookingId){
        String url=BASE_URL+"/bookings/{bookingId}";
        System.out.println("Get Booking url:"+url);
        return restTemplate.getForObject(url,BookingResponse.class,bookingId);
    }

    public List<BookingResponse> getBookingByUserId(Long userId){
        String url=BASE_URL+"/bookings/user/{userId}";
        BookingResponse[] responses = restTemplate.getForObject(url,BookingResponse[].class,userId);
        assert responses != null;
        return Arrays.asList(responses);
    }

    public BookingResponse cancelBooking(Long bookingId) {
        String url = BASE_URL + " /bookings/{bookingId}";
        try {
            // Perform DELETE operation
            restTemplate.delete(url, bookingId);

            // Create and return a response object (example)
            BookingResponse response = new BookingResponse();
            response.setBookingId(bookingId);
            response.setStatus("Cancelled");

            return response;
        } catch (HttpClientErrorException.NotFound e) {
            throw new RuntimeException("Booking not found for ID: " + bookingId, e);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while cancelling the booking.", e);
        }

    }
}
