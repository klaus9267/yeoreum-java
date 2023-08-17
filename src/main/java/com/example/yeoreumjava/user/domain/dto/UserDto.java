package com.example.yeoreumjava.user.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;

    @NotNull(message = "이름을 입력해 주세요.")
    private String name;

    @NotNull(message = "학과를 입력해 주세요.")
    private Long majorId;
}
