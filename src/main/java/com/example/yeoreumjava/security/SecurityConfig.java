package com.example.yeoreumjava.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf().disable()
                           .formLogin().disable()
                           .cors()

                           .and()
                           .authorizeHttpRequests() // 요청 관리
                           .requestMatchers("/api/auth/login", "/api/auth/join").permitAll()
                           .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                           //.requestMatchers(HttpMethod.GET, "/api/auth").authenticated()

                           .and()
                           .sessionManagement()
                           .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                           .and()
                           .headers().frameOptions().disable()

                           .and()
                           .build();
    }
}
