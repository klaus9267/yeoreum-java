package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class MeetingDto {
    private long id;

    @NotNull(message = "만남장소를 입력해 주세요.")
    private String place;

    @NotNull(message = "이름을 입력해 주세요.")
    private String time;

    @NotNull(message = "boardId를 입력해 주세요.")
    private Long boardId;
}
