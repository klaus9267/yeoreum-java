package com.example.yeoreumjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class YeoreumJavaApplication {
    public static void main(String[] args) {
        SpringApplication.run(YeoreumJavaApplication.class, args);
    }
}
