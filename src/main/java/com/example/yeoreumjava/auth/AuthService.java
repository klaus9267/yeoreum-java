package com.example.yeoreumjava.auth;

import com.example.yeoreumjava.auth.domain.dto.AuthRequest;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    public void login(AuthRequest authRequest) {

    }
}
