package com.elastic.kibana.demo.controller;

import com.elastic.kibana.demo.service.LoggingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {


    private final LoggingService loggingService;

    public MyController(LoggingService loggingService) {
        this.loggingService = loggingService;
        // Log an event when the controller is created
        loggingService.logEvent("INFO", "Controller initialized successfully");
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        // Log an event when this endpoint is accessed
        loggingService.logEvent("INFO", name);
        loggingService.logEvent("ERROR", name);
        return "Hello, World!";
    }
}
