package com.iamsajan.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CinemaHall {
    @Id
    @Column(length = 50)
    private String id;
    private String name;
    private int totalSeats;
    @ManyToOne(cascade = CascadeType.ALL)
    private Cinema cinema;
}
