package com.iamsajan.app.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CinemaRequestDto {
    private String id;
    private String name;
    private int totalCinemaHalls;
    private String cityId;
}
