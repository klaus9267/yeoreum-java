package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class HostResponse {
    @NotBlank
    private long id;

    @NotBlank
    private Long meetingId;

    @NotBlank
    private Long userId;
}
