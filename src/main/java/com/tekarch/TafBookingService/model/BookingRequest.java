package com.tekarch.TafBookingService.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookingRequest implements Serializable {
    private Long userId;
    private Long flightId;
    private String status;
}
