package com.example.yeoreumjava.board.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class BoardResponse {
    private Long id;
    private String title;
    private String content;

    private Long writerId;
    private Long meetingId;
}
