package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class GuestRequest {
    @NotNull(message = "meetingId를 입력해 주세요.")
    private Long meetingId;

    @NotNull(message = "userId를 입력해 주세요.")
    private Long userId;
}
