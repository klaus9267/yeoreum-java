package com.example.yeoreumjava.user.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotBlank(message = "name을 입력해 주세요.")
    private String name;

    @NotNull(message = "majorId를 입력해 주세요.")
    private Long majorId;
}
