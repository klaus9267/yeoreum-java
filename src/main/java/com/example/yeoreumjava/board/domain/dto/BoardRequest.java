package com.example.yeoreumjava.board.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class BoardRequest {
    // board entity
    @NotBlank(message = "제목을 입력해 주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해 주세요.")
    private String content;

    @NotBlank(message = "writerId를 입력해 주세요.")
    private Long writerId;

    @NotBlank(message = "meetingId를 입력해 주세요.")
    private Long meetingId;

    // meeting entity
    @NotBlank(message = "만남장소를 입력해 주세요.")
    private String place;

    @NotBlank(message = "만남시간을를 입력해 주세요.")
    private String time;
}
