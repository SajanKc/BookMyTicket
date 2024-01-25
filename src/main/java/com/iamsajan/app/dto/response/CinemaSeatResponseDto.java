package com.iamsajan.app.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CinemaSeatResponseDto {
    private String id;
    private int seatNumber;
    private int type;
    private String cinemaHallId;
}
