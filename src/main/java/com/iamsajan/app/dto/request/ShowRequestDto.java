package com.iamsajan.app.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ShowRequestDto {
    private String id;
    private Date dateTime;
    private Date startTime;
    private Date endTime;
    private String movieId;
    private String cinemaHallId;
}