package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class HostResponse {
    @NotBlank(message = "id를 입력해 주세요.")
    private long id;

    @NotNull(message = "meetingId를 입력해 주세요.")
    private Long meetingId;

    @NotBlank(message = "userId를 입력해 주세요.")
    private Long userId;
}
