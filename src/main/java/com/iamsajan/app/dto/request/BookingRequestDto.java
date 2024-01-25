package com.iamsajan.app.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BookingRequestDto {
    private String id;
    private int numberOfSeats;
    private Date timestamp;
    private int status;
    private String customerId;
    private String showId;
}
