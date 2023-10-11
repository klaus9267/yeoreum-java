package com.example.yeoreumjava.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @GetMapping("/test")
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok("token");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        return ResponseEntity.ok("give token!!");
    }
    @PostMapping("/join")
    public ResponseEntity<String> join() {
        return ResponseEntity.ok("give token!!");
    }
}
