package com.example.yeoreumjava.user.domain.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotNull
    @Size(min = 3,max = 100)
    private String username;

    @NotNull
    private boolean gender;
}
