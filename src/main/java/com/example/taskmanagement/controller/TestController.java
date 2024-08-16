package com.example.taskmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping("/secure-welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome this is secured endpoint");
    }
}
