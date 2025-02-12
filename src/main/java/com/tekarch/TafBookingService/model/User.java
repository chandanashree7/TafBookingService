package com.tekarch.TafBookingService.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private Long id;
    private String userName;
    private String email;
    private String phone;
}
