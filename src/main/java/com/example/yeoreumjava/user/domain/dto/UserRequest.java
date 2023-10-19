package com.example.yeoreumjava.user.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotNull(message = "username을 입력해 주세요")
    @Size(min = 3,max = 100,message = "username의 글자수 제한을 맞춰주세요")
    private String username;

    @NotNull(message = "email을 입력해 주세요")
    @Email(message = "email 형식을 맞춰 주세요")
    private String email;

    @NotNull(message = "password 입력해 주세요")
    @Size(min = 3,max = 100,message = "password의 글자수 제한을 맞춰주세요")
    private String password;

    private boolean gender;

    @NotNull(message = "majorId을 입력해 주세요")
    private Long majorId;
}
