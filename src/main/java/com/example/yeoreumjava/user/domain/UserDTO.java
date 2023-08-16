package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.major.domain.Major;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;

    @NotNull(message = "이름을 입력해 주세요.")
    private String name;

    @NotNull
    private Long majorId;
}
