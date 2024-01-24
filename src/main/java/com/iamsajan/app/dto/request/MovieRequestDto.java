package com.iamsajan.app.dto.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MovieRequestDto {
    private String id;
    private String title;
    private String description;
    private String duration;
    private String language;
    private Date releaseDate;
    private String country;
    private String genre;
}
