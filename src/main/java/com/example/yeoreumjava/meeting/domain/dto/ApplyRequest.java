package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class ApplyRequest {
    @NotBlank(message = "title를 입력해 주세요.")
    private String title;

    @NotBlank(message = "content를 입력해 주세요.")
    private String content;

    @NotNull(message = "guestList를 입력해 주세요.")
    private List<Long> guestList = new ArrayList<>();
}
