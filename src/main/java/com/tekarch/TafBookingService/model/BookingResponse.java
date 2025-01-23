package com.tekarch.TafBookingService.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingResponse implements Serializable {

    private User user;
    private Flight flight;
    private String status;
    private Long bookingId;


}
