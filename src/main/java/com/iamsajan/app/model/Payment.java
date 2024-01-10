package com.iamsajan.app.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Payment {
    @Id
    @Column(length = 50)
    private String id;
    private Number amount;
    private Date timestamp;
    private int paymentMethod; // enum PaymentMethod
    private String remoteTransactionId;
    private String discountCouponId;
    @ManyToOne(cascade = CascadeType.ALL)
    private Booking booking; // one booking one payment
}
