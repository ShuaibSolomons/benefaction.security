package com.benefaction.security.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hello")
@RequiredArgsConstructor
public class HelloDummy {

    @GetMapping("/dummy")
    public ResponseEntity<String> testAuth() {
        return ResponseEntity.ok("Test Auth Namaste");
    }
}
