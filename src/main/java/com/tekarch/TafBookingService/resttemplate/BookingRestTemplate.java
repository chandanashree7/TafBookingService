package com.tekarch.TafBookingService.resttemplate;

import com.tekarch.TafBookingService.model.BookingRequest;
import com.tekarch.TafBookingService.model.BookingResponse;
import com.tekarch.TafBookingService.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class BookingRestTemplate {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.base.url}")
    private final String BASE_URL;

    public BookingRestTemplate(@Value("${api.base.url}") String baseUrl) {
        BASE_URL = baseUrl;
    }

    //private final String BASE_URL="http://localhost:8083/api";

    public BookingResponse createBooking(BookingRequest requestBooking){
        //String url=BASE_URL+"/bookings";
        BookingResponse response =  restTemplate.postForObject(BASE_URL,requestBooking, BookingResponse.class);
        System.out.println("Booking response:"+response);
        return response;
    }

    public BookingResponse getBooking(Long bookingId){
        //String url=BASE_URL+"/bookings/{bookingId}";
        //System.out.println("Get Booking url:"+url);
        return restTemplate.getForObject(BASE_URL+"{bookingId}",BookingResponse.class,bookingId);
    }

    public List<BookingResponse> getBookingByUserId(Long userId){
        //String url=BASE_URL+"/bookings/user/{userId}";
        BookingResponse[] responses = restTemplate.getForObject(BASE_URL+"/user/{userId}",BookingResponse[].class,userId);
        assert responses != null;
        return Arrays.asList(responses);
    }

    public BookingResponse cancelBooking(Long bookingId) {
        //String url = BASE_URL + " /bookings/{bookingId}";
        try {
            // Perform DELETE operation
            restTemplate.delete(BASE_URL+"{bookingId}", bookingId);

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
