package com.iamsajan.app.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MovieResponseDto {
    private String id;
    private String title;
    private String description;
    private String duration;
    private String language;
    private String releaseDate;
    private String country;
    private String genre;
}
