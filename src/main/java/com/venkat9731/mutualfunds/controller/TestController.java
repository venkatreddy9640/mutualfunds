package com.venkat9731.mutualfunds.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/v1")
    public Map testV1() {
        return Map.of("status", "OK", "version", "V1");
    }
}
