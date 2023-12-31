package com.example.yeoreumjava.meeting.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class ApplyResponse {
    private Long id;
    private String title;
    private String content;
    private Long meetingId;

    private List<GuestResponse> guestList = new ArrayList<>();
}
