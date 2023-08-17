package com.example.yeoreumjava.user.domain;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;

    @NotNull(message = "이름을 입력해 주세요.")
    private String name;

    @NotNull(message = "majorId를 입력해 주세요.")
    private Long majorId;
}
