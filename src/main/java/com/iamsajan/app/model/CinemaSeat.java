package com.iamsajan.app.model;

import jakarta.persistence.*;

@Entity
public class CinemaSeat {
    @Id
    @Column(length = 50)
    private String id;
    private int seatNumber;
    private int type;
    @ManyToOne(cascade = CascadeType.ALL)
    private CinemaHall cinemaHall;
}
