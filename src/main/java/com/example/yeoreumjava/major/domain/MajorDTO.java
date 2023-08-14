package com.example.yeoreumjava.major.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MajorDTO {
    private Long id;

    @NotBlank
    private String name;
}
