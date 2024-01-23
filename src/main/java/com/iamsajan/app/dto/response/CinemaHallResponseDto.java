package com.iamsajan.app.dto.response;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Builder
public class CinemaHallResponseDto {
    private String id;
    private String name;
    private int totalSeats;
    private String cinemaId;
}
