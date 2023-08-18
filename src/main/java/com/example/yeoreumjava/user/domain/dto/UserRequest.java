package com.example.yeoreumjava.user.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {
    @NotBlank(message = "이름을 입력해 주세요.")
    private String name;

    @NotBlank(message = "majorId를 입력해 주세요.")
    private Long majorId;
}
