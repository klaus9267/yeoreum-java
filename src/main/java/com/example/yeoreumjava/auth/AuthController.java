package com.example.yeoreumjava.auth;

import com.example.yeoreumjava.auth.domain.dto.LoginDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto loginDto) {
        authService.login(loginDto);
        return ResponseEntity.ok("give token!!");
    }
    @PostMapping("/join")
    public ResponseEntity<String> join() {
        return ResponseEntity.ok("give token!!");
    }

}
