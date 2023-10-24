package com.example.yeoreumjava.meeting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class MeetingResponse {
    private Long id;
    private String place;
    private String time;
}
