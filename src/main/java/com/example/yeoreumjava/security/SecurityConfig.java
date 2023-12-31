package com.example.yeoreumjava.security;

import com.example.yeoreumjava.security.entrypoint.JwtAuthenticationEntryPoint;
import com.example.yeoreumjava.security.filter.JwtFilter;
import com.example.yeoreumjava.security.handler.JwtAccessDeniedHandler;
import com.example.yeoreumjava.security.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class SecurityConfig {
private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
private final JwtUtil jwtUtil;

    @Bean
    public PasswordEncoder getpasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        log.info("security start!!");

        return httpSecurity.csrf().disable()
                           .formLogin().disable()
                           .cors()

                           .and()
                           .exceptionHandling()
                           .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                           .accessDeniedHandler(jwtAccessDeniedHandler)

                           .and()
                           .authorizeHttpRequests() // 요청 관리
                           .requestMatchers("/api/users/login").permitAll()
                           .requestMatchers("/api/users/join").permitAll()
                           .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                           .anyRequest().authenticated()

                           .and()
                           .sessionManagement()
                           .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                           .and()
                           .headers().frameOptions().disable()

                           .and()
                           .addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)

                           .build();
    }
}
