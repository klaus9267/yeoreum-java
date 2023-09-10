package com.example.yeoreumjava.meeting;

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

    @GetMapping("{meetingId}")
    public ResponseEntity<List<ApplyResponse>> findAllAppliesByMeetingId(@PathVariable("meetingId") Long meetingId) {
        List<ApplyResponse> applyResponseList = meetingService.findAllAppliesByMeetingId(meetingId);

        return ResponseEntity.ok(applyResponseList);
    }

    @GetMapping("{applyId}")
    public ResponseEntity<ApplyResponse> findApplyResponseById(@PathVariable("applyId") Long applyId) {
        ApplyResponse applyResponse = meetingService.findApplyResponseById(applyId);

        return ResponseEntity.ok(applyResponse);
    }

    @PostMapping("{meetingId}")
    public ResponseEntity<String> applyMeeting(@PathVariable("meetingId") Long meetingId,
                                               @Valid @RequestBody ApplyRequest applyRequest) {
        meetingService.applyMeeting(meetingId, applyRequest);

        return ResponseEntity.ok("신청 완료");
    }

    @PatchMapping("{applyId}")
    public ResponseEntity<String> acceptApply(@PathVariable("applyId") Long applyId) {
        meetingService.acceptApply(applyId);

        return ResponseEntity.ok("만남 성사");
    }
}
