package com.iamsajan.app.model;

import jakarta.persistence.*;

@Entity
public class City {
    @Id
    @Column(length = 50)
    private String id;
    private String name;
    private String state;
    private String zipCode;
}
