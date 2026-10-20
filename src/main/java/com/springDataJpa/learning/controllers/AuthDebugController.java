package com.springDataJpa.learning.controllers;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthDebugController {

    @GetMapping("/api/v1/me")
    public Map<String, Object> getCurrentUser(
            Authentication authentication) {

        return Map.of(
                "username", authentication.getName(),
                "authorities", authentication.getAuthorities()
        );
    }
}
