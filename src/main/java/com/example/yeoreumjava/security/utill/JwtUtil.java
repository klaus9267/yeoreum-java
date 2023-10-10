package com.example.yeoreumjava.security.utill;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {
    private static String createJwt(String username, String secretKey, Long expiredMilliSecond) {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        Claims claims = Jwts.claims();
        claims.put("username", username);

        return Jwts.builder()
                   .setIssuedAt(new Date(System.currentTimeMillis()))
                   .setExpiration(new Date(System.currentTimeMillis() + expiredMilliSecond))
                   .signWith(key)
                   .compact();

    }
}
