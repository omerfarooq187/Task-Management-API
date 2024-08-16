package com.example.taskmanagement.auth.controller;

import com.example.taskmanagement.auth.AuthenticationRequest;
import com.example.taskmanagement.auth.AuthenticationResponse;
import com.example.taskmanagement.auth.RegisterRequest;
import com.example.taskmanagement.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticateUser(
            @RequestBody AuthenticationRequest request
    ) {
        System.out.println("Authentication Running...");
        return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome this is non secure endpoint");
    }
}
