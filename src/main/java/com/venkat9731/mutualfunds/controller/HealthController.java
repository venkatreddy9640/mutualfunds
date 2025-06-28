package com.venkat9731.mutualfunds.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthController {

    @GetMapping("/")
    public Map healthCheck() {
        return Map.of("status", "OK");
    }
}
