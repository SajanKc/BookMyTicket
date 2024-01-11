package com.iamsajan.app.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class City {
    @Id
    @Column(length = 50)
    private String id;
    private String name;
    private String state;
    private String zipCode;
}
