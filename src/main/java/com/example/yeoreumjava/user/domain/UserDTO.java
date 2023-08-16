package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.major.domain.Major;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;

    @NotBlank(message = "이름을 입력해 주세요.")
    private String name;

    @NotBlank(message = "학과를 선택해 주세요.")
    private Long majorId;
}
