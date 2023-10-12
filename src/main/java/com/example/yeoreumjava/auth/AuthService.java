package com.example.yeoreumjava.auth;

import com.example.yeoreumjava.auth.domain.Authentication;
import com.example.yeoreumjava.auth.domain.dto.AuthRequest;
import com.example.yeoreumjava.auth.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;
    private final AuthRepository authRepository;
    public void login(AuthRequest authRequest) {

    }

    public void join(AuthRequest authRequest) {
        if (loadAuthentication(authRequest.getEmail()) != null) {
            throw new IllegalStateException("이미 가입된 사용자입니다.");
        }
    }

    public Authentication loadAuthentication(String email) {
        return findByEmail(email).orElseThrow(() -> new NoSuchElementException("해당 이메일로 가입된 사용자가 없습니다."));
    }

    public Optional<Authentication> findByEmail(String email) {
        return authRepository.findByEmail(email);
    }
}
