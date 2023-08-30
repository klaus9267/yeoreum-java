package com.example.yeoreumjava.meeting.domain.dto;

import com.example.yeoreumjava.meeting.domain.Guest;
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
    private Long content;

    private List<Guest> guestList = new ArrayList<>();
}
