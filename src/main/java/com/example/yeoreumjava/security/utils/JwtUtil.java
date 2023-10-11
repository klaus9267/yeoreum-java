package com.example.yeoreumjava.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static String createJwt(Long userId, String secretKey, Long expiredMs) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        Claims claims = Jwts.claims();
        claims.put("userId", userId);

        return Jwts.builder()
                   .setClaims(claims)
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setExpiration(new Date(System.currentTimeMillis() + expiredMs))
                   .signWith(key)
                   .compact();
    }
}
