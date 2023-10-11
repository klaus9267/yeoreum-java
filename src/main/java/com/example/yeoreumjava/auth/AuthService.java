package com.example.yeoreumjava.auth;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    public String login(String username, String password) {

        return "로그인 성공!!";
    }
}
