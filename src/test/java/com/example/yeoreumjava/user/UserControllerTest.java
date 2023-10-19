package com.example.yeoreumjava.user;

import com.example.yeoreumjava.security.provider.TokenProvider;
import com.example.yeoreumjava.user.domain.dto.LoginDto;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

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
    @WithAnonymousUser
    void join() throws Exception {
        UserRequest userRequest = UserRequest.builder()
                                             .username("test")
                                             .email("klaus9267@gmail.com")
                                             .password("asdasdadas")
                                             .gender(true)
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
    void login() throws Exception {
        LoginDto loginDto = LoginDto.builder()
                                    .email("1@1.com")
                                    .password("passworddddddd")
                                    .build();
        String body = objectMapper.writeValueAsString(loginDto);

        mvc.perform(MockMvcRequestBuilders.post("/api/users/login")
                                          .content(body)
                                          .contentType(MediaType.APPLICATION_JSON))
           .andExpect(status().isOk())
           .andDo(print());
    }
}