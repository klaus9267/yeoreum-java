package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.board.domain.dto.BoardResponse;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.domain.dto.ApplyResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
@RequiredArgsConstructor
public class MeetingController {
    private final MeetingService meetingService;

    @GetMapping("{id}")
    public ResponseEntity<List<ApplyResponse>> findAllAppliesById(@PathVariable("id") Long id) {
        List<ApplyResponse> applyResponseList = meetingService.findAllAppliesByMeetingId(id);

        return ResponseEntity.ok(applyResponseList);
    }

    @PostMapping("{id}")
    public ResponseEntity<String> applyMeeting(@PathVariable("id") Long id,
                                               @Valid @RequestBody ApplyRequest applyRequest) {
        meetingService.applyMeeting(id, applyRequest);

        return ResponseEntity.ok("신청 완료");
    }
}
