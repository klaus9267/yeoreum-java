package com.example.yeoreumjava.auth;

import com.example.yeoreumjava.auth.domain.dto.AuthRequest;
import com.example.yeoreumjava.security.provider.TokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody AuthRequest authRequest) {
        authService.login(authRequest);
        return ResponseEntity.ok("success");
    }
    @PostMapping("/join")
    public ResponseEntity<String> join(@Valid @RequestBody AuthRequest authRequest) {
        authService.join(authRequest);
        return ResponseEntity.ok("give token!!");
    }

}
