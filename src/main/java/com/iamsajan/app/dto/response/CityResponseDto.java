package com.iamsajan.app.dto.response;

import lombok.Builder;

@Builder
public class CityResponseDto {
    private String id;
    private String name;
    private String state;
    private String zipCode;
}
