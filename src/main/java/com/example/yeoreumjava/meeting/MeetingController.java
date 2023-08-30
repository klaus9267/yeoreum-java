package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.board.domain.dto.BoardResponse;
import com.example.yeoreumjava.meeting.domain.dto.ApplyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
@RequiredArgsConstructor
public class MeetingController {
    private final MeetingService meetingService;
    @GetMapping("{id}")
    public ResponseEntity<List<ApplyResponse>> findAllMeetingRequestById(@PathVariable("id") Long id) {
//        List<ApplyResponse> applyResponseList = meetingService.fi

        return ResponseEntity.ok(applyResponseList);
    }
}
