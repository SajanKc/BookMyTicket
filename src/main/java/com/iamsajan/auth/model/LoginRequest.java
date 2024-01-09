package com.iamsajan.auth.model;

import lombok.Builder;
import lombok.Getter;

/**
 * @Author Sajan Kc
 * @Date 2023/01/07
 * @Description: This class is used to represent login request
 */
@Getter
@Builder
public class LoginRequest {
    private String username;
    private String password;
}
