package com.example.yeoreumjava.auth.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class loginDto {
    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;
}