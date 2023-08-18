package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class MeetingResponse {
    private long id;

    @NotBlank(message = "만남장소를 입력해 주세요.")
    private String place;

    @NotBlank(message = "이름을 입력해 주세요.")
    private String time;
}
