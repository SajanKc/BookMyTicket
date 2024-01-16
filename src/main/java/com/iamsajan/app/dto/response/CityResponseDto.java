package com.iamsajan.app.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityResponseDto {
    private String id;
    private String name;
    private String state;
    private String zipCode;
}
