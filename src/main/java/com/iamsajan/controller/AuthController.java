package com.iamsajan.controller;

import com.iamsajan.model.security.LoginRequest;
import com.iamsajan.model.security.LoginResponse;
import com.iamsajan.security.JwtIssuer;
import com.iamsajan.security.UserPrincipal;
import com.iamsajan.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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

