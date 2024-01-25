package com.iamsajan.app.dto.response;

import com.iamsajan.app.model.Customer;
import com.iamsajan.app.model.Show;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingResponseDto {
    private String id;
    private int numberOfSeats;
    private String timestamp;
    private String status;
    private Customer customer;
    private Show show;
}
