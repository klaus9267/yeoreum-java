package com.example.yeoreumjava.user.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    @NotNull(message = "id를 입력해 주세요.")
    private Long id;

    @NotNull(message = "name을 입력해 주세요.")
    private String name;

    @NotNull(message = "majorId를 입력해 주세요.")
    private Long majorId;
}
