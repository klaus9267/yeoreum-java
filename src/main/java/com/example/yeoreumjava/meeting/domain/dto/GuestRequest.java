package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class GuestRequest {
    @NotBlank(message = "meetingId를 입력해 주세요.")
    private Long meetingId;

    @NotBlank(message = "guestId를 입력해 주세요.")
    private Long userId;
}
