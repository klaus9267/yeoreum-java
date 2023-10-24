package com.example.yeoreumjava.board.domain.dto;

import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.dto.ApplyResponse;
import com.example.yeoreumjava.meeting.domain.dto.HostResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class BoardResponse {
    private Long id;
    private String title;
    private String content;

    private Long writerId;
    private Long meetingId;
    private List<Host> hostList = new ArrayList<>();
    private List<Apply> applyList = new ArrayList<>();
}
