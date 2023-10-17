package com.example.yeoreumjava.auth;

import com.example.yeoreumjava.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final PasswordEncoder passwordEncoder;

    private final UserService userService;
//    public void login(AuthRequest authRequest) {
//        String hashedPassword = passwordEncoder.encode(authRequest.getPassword());
//        Authentication authentication = loadAuthentication(authRequest.getUsername());
//
//        if (!authentication.getHashedPassword().equals(hashedPassword)) {
//            throw new IllegalStateException("비밀번호가 틀렸습니다.");
//        }
//    }

}
