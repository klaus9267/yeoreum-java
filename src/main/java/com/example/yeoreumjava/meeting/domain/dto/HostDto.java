package com.example.yeoreumjava.meeting.domain.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class HostDto {
    private Long id;

    @NotNull(message = "host id를 입력해 주세요.")
    private Long userId;

    @NotNull(message = "만남 id를 입력해 주세요.")
    private Long meetingId;
}
