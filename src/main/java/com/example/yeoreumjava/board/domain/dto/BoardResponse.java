package com.example.yeoreumjava.board.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class BoardResponse {
    private long id;

    @NotNull(message = "제목을 입력해 주세요.")
    private String title;

    @NotNull(message = "내용을 입력해 주세요.")
    private String content;

    @NotNull(message = "writerId를 입력해 주세요.")
    private Long writerId;

    @NotNull(message = "meetingId를 입력해 주세요.")
    private Long meetingId;
}
