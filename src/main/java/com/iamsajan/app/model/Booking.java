package com.iamsajan.app.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Booking {
    @Id
    @Column(length = 50)
    private String id;
    private int numberOfSeats;
    private Date timestamp;
    private int status; // enum Status
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;  // one user many bookings
    @ManyToOne(cascade = CascadeType.ALL)
    private Show show;  // one show many bookings

}
