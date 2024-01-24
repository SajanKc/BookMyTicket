package com.iamsajan.app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
public class Customer {
    @Id
    @Column(length = 50)
    private String id;
    private String username;
    private String email;
    private String phone;
}
