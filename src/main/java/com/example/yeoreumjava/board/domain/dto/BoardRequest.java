package com.example.yeoreumjava.board.domain.dto;

import com.example.yeoreumjava.meeting.domain.Host;
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
public class BoardRequest {
    // board
    @NotBlank(message = "title을 입력해 주세요.")
    private String title;

    @NotBlank(message = "content을 입력해 주세요.")
    private String content;

    @NotNull(message = "writerId를 입력해 주세요.")
    private Long writerId;

    // meeting
    @NotBlank(message = "place를 입력해 주세요.")
    private String place;

    @NotBlank(message = "time를 입력해 주세요.")
    private String time;

    // host
    @NotNull(message = "hostList을 입력해 주세요.")
    List<Long> hostList = new ArrayList<>();

}
