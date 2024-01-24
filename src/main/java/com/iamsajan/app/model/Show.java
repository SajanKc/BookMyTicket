package com.iamsajan.app.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Show {
    @Id
    @Column(length = 50)
    private String id;
    private Date dateTime;
    private Date startTime;
    private Date endTime;
    @ManyToOne(cascade = CascadeType.ALL)
    private Movie movie; // one movie many shows
    @OneToOne(cascade = CascadeType.ALL)
    private CinemaHall cinemaHall; // one cinema hall many shows
}
