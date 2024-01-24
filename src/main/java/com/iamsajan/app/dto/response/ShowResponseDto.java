package com.iamsajan.app.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ShowResponseDto {
    private String id;
    private Date dateTime;
    private Date startTime;
    private Date endTime;
    private String movieId;
    private String cinemaHallId;
}
