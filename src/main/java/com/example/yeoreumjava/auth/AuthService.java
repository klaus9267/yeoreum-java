package com.example.yeoreumjava.auth;

import com.example.yeoreumjava.auth.domain.Authentication;
import com.example.yeoreumjava.auth.domain.dto.AuthRequest;
import com.example.yeoreumjava.auth.repository.AuthRepository;
import com.example.yeoreumjava.user.UserService;
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

    private final UserService userService;
    public void login(AuthRequest authRequest) {
        String hashedPassword = passwordEncoder.encode(authRequest.getPassword());
        Authentication authentication = loadAuthentication(authRequest.getUsername());

        if (!authentication.getHashedPassword().equals(hashedPassword)) {
            throw new IllegalStateException("비밀번호가 틀렸습니다.");
        }
    }

    public void join(AuthRequest authRequest) {
        if (findByEmail(authRequest.getUsername()).isPresent()) {
            throw new IllegalStateException("이미 가입된 사용자입니다.");
        }

        String hashedPassword = passwordEncoder.encode(authRequest.getPassword());
        Authentication authentication = Authentication.builder()
                                                      .username(authRequest.getUsername())
                                                      .hashedPassword(hashedPassword)
                                                      .build();
        Authentication auth = authRepository.save(authentication);

    }

    public Authentication loadAuthentication(String email) {
        return findByEmail(email).orElseThrow(() -> new NoSuchElementException("해당 이메일로 가입된 사용자가 없습니다."));
    }

    public Optional<Authentication> findByEmail(String email) {
        return authRepository.findByUsername(email);
    }
}
