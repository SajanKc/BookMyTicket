package com.iamsajan.app.model;

import jakarta.persistence.*;

@Entity
public class Cinema {
    @Id
    @Column(length = 50)
    private String id;
    private String name;
    private int totalCinemaHalls;
    @ManyToOne(cascade = CascadeType.ALL)
    private City city; // one city many cinemas
}
