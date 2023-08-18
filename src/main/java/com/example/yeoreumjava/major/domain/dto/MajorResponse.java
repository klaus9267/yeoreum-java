package com.example.yeoreumjava.major.domain.dto;

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
public class MajorResponse {
    @NotNull(message = "id가 누락됬습니다.")
    private Long id;

    @NotBlank(message = "name이 누락됬습니다.")
    private String name;
}
