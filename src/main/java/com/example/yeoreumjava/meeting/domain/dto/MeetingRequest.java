package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class MeetingRequest {
    // meeting
    @NotBlank(message = "place를 입력해 주세요.")
    private String place;

    @NotBlank(message = "time을 입력해 주세요.")
    private String time;

    // host
    @NotBlank(message = "hostList을 입력해 주세요.")
    List<Long> hostList = new ArrayList<>();
}
