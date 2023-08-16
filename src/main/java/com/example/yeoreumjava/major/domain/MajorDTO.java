package com.example.yeoreumjava.major.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MajorDTO {
    private Long id;

    @NotBlank(message = "학과를 입력해 주세요.")
    private String name;
}
