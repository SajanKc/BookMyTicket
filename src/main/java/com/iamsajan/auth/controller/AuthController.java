package com.iamsajan.auth.controller;

import com.iamsajan.auth.model.LoginRequest;
import com.iamsajan.auth.model.LoginResponse;
import com.iamsajan.auth.security.UserPrincipal;
import com.iamsajan.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Sajan Kc
 * @Date 2023/01/07
 * @Description: This class is used to handle authentication requests
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest) {
        return authService.attemptLogin(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @GetMapping("/secured-path")
    public String securedPath(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return "This is a secured path " + userPrincipal.getUsername();
    }
}

