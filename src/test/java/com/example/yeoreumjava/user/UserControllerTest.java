package com.example.yeoreumjava.user;

import com.example.yeoreumjava.security.provider.TokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    private UserService userService;
    @MockBean
    private TokenProvider tokenProvider;

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