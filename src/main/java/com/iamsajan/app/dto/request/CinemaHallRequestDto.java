package com.iamsajan.app.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CinemaHallRequestDto {
    private String id;
    private String name;
    private int totalSeats;
    private String cinemaId;
}
