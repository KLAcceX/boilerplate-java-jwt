package com.kl.jwt.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kl.jwt.dtos.requests.LoginRequestDTO;
import com.kl.jwt.dtos.requests.RegisterRequestDTO;
import com.kl.jwt.dtos.responses.LoginResponseDTO;
import com.kl.jwt.dtos.responses.RegisterResponseDTO;
import com.kl.jwt.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        var response = service.register(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {
        var response = service.login(request);
        return ResponseEntity.ok(response);
    }
}
