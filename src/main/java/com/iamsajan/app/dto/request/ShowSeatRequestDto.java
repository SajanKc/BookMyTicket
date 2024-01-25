package com.iamsajan.app.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShowSeatRequestDto {
    private String Id;
    private int status;
    private Number price;
    private String showId;
    private String bookingId;
    private String cinemaSeatId;
}
