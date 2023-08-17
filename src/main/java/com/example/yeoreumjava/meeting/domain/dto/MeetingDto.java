package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MeetingDto {
    private Long id;

    @NotNull(message = "예상 만남 장소를 입력해 주세요.")
    private String place;

    @NotNull(message = "예상 만남 시간을 입력해 주세요.")
    private String time;

    @NotNull(message = "게시글 id를 입력해 주세요.")
    private Long boardId;
}
