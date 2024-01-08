package com.iamsajan.controller;

import com.iamsajan.model.security.LoginRequest;
import com.iamsajan.model.security.LoginResponse;
import com.iamsajan.security.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Author Sajan Kc
 * @Date 2023/01/07
 * @Description: This class is used to handle authentication requests
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class AuthController {
    private final JwtIssuer jwtIssuer;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest) {
        // TODO: implement login logic
        var token = jwtIssuer.issueToken(UUID.randomUUID().toString(), loginRequest.getUsername(), List.of("USER"));
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }

    @GetMapping("/secured-path")
    public String securedPath() {
        return "This is a secured path";
    }
}

