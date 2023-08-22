package com.example.yeoreumjava.common.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GlobalExceptionHandlerTest {
    @Test
    void exceptionText() {
        throw new RuntimeException("테스트임미다!!!");
    }
}