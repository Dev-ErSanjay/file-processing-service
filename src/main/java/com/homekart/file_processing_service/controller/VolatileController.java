package com.homekart.file_processing_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homekart.file_processing_service.service.VolatileDemoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/volatile")
@RequiredArgsConstructor
public class VolatileController {

    private final VolatileDemoService volatileDemoService;

    @GetMapping("/start")
    public String start() {
        volatileDemoService.startProcessing();
        return "Worker started";
    }

    @GetMapping("/stop")
    public String stop() {
        volatileDemoService.stopProcessing();
        return "Worker stoped";
    }
}
