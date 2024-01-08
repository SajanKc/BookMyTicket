package com.iamsajan.controller;

import com.iamsajan.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/admin")
public class AdminController {

    @GetMapping
    public String getAdmin(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return "This is admin: " + userPrincipal.getUsername();
    }
}
