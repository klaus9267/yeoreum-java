package com.example.yeoreumjava.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@SpringBootTest
@WebMvcTest
class UserControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    private UserService userService;
    @Test
    void join() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test"))
           .andDo(print());
    }

    @Test
    void login() {
    }

    @Test
    void findUserById() {
    }

    @Test
    void createUser() {
    }

    @Test
    void deleteUser() {
    }
}