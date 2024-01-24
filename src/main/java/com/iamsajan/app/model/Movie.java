package com.iamsajan.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Movie {
    @Id
    @Column(length = 50)
    private String id;
    private String title;
    private String description;
    private String duration;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
}
