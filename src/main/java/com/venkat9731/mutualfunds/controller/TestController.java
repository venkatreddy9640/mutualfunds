package com.venkat9731.mutualfunds.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    private final MeterRegistry meterRegistry;

    public TestController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/v1")
    public Map testV1() throws UnknownHostException {
        meterRegistry.counter("test_v1_requests").increment();
        return Map.of("status", "OK", "version", "V1", "IP", Inet4Address.getLocalHost());
    }

    @GetMapping("/v2")
    public Map testV2() throws UnknownHostException {
        meterRegistry.counter("test_v2_requests").increment();
        return Map.of("status", "OK", "version", "V2", "IP", Inet4Address.getLocalHost());
    }
}
