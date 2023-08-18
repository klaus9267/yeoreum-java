package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class MeetingResponse {
    @NotNull(message = "id를 입력해 주세요.")
    private long id;

    @NotBlank(message = "place를 입력해 주세요.")
    private String place;

    @NotBlank(message = "time을 입력해 주세요.")
    private String time;
}
