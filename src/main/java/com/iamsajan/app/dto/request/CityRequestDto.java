package com.iamsajan.app.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityRequestDto {
    private String id;
    private String name;
    private String state;
    private String zipCode;
}
