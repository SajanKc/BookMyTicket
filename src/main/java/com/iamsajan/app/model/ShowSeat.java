package com.iamsajan.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ShowSeat {
    @Id
    @Column(length = 50)
    private String id;
    private int status;
    private Number price;
    @ManyToOne(cascade = CascadeType.ALL)
    private Show show;
    @ManyToOne(cascade = CascadeType.ALL)
    private Booking booking;
    @ManyToOne(cascade = CascadeType.ALL)
    private CinemaSeat cinemaSeat;
}
