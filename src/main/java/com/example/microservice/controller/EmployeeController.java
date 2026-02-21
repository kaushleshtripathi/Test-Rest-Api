package com.example.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmployeeController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/orders")
    public String createOrder(@RequestBody String order) {

        // business logic
        System.out.println("Order received");

        // send to sidecar
        restTemplate.postForObject(
                "http://localhost:9001/sidecar/log",
                order,
                String.class
        );

        return "Order processed";
    }

    @PostMapping("/sidecar/log")
    public String logAndForward(@RequestBody String payload) {

        // cross-cutting concern
        System.out.println("Sidecar logging: " + payload);

        // simulate forward
        // call external API / kafka / metrics system

        return "Logged by sidecar";
    }
}