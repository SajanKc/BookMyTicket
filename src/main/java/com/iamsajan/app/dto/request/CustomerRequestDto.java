package com.iamsajan.app.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRequestDto {
    private String id;
    private String username;
    private String email;
    private String phone;
}
