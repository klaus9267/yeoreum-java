package com.example.yeoreumjava.user;

import com.example.yeoreumjava.security.provider.TokenProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
@MockBean(JpaMetamodelMappingContext.class)
class UserControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    private UserService userService;
    @MockBean
    private TokenProvider tokenProvider;

    @Test
    @WithMockUser(username = "user1",roles = "USER")
    void join() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/users/test"))
           .andExpect(status().isOk())
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