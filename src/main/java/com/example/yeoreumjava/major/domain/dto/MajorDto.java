package com.example.yeoreumjava.major.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class MajorDto {
    private Long id;

    @NotNull(message = "학과를 입력해 주세요.")
    private String name;
}
