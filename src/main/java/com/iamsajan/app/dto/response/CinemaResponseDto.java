package com.iamsajan.app.dto.response;

import com.iamsajan.app.model.City;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CinemaResponseDto {
    private String id;
    private String name;
    private int totalCinemaHalls;
    private City cityId;
}
