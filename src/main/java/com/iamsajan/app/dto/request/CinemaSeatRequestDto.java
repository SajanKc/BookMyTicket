package com.iamsajan.app.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CinemaSeatRequestDto {
    private String id;
    private int seatNumber;
    private int type;
    private String cinemaHallId;
}
