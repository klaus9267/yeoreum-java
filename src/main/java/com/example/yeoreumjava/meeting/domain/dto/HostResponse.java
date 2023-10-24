package com.example.yeoreumjava.meeting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class HostResponse {
    private Long id;
    private Long meetingId;
    private String username;
}
