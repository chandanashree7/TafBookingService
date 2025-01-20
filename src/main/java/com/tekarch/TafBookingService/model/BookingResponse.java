package com.tekarch.TafBookingService.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookingResponse implements Serializable {

    private User user;
    private Flight flight;
    private String status;
    private Long bookingId;


}
