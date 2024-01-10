package com.iamsajan.app.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Movie {
    @Id
    @Column(length = 50)
    private String id;
    private String title;
    private String description;
    private Date duration;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
}
