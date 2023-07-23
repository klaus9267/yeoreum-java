package com.example.yeoreumjava.major;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class MajorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void findAllMajors() throws Exception{
        System.out.println(mockMvc.perform(MockMvcRequestBuilders.get("/api/majors")));
    }
}