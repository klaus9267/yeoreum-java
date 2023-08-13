package com.example.yeoreumjava.major.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MajorDTO {
    private Long id;
    private String name;
}
