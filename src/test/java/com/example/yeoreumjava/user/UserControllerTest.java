package com.example.yeoreumjava.user;

import com.example.yeoreumjava.security.provider.TokenProvider;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.lang.Boolean.TRUE;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureMockMvc(addFilters = false)
class UserControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private UserService userService;
    @MockBean
    private TokenProvider tokenProvider;

    @Test
//    @WithMockUser(username = "user1",roles = "USER")
    @WithAnonymousUser
    void join() throws Exception {
        UserRequest userRequest = UserRequest.builder()
                                             .username("test")
                                             .email("klaus9267@gmail.com")
                                             .password("asdasdadas")
                                             .gender(TRUE)
                                             .majorId(1L)
                                             .build();
        String body = objectMapper.writeValueAsString(userRequest);

        mvc.perform(MockMvcRequestBuilders.post("/api/users/join")
                                          .content(body)
                                          .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isCreated())
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