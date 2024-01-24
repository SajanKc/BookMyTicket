package com.iamsajan.app.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponseDto {
    private String id;
    private String username;
    private String email;
    private String phone;
}
