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

    @GetMapping("{meegingId}")
    public ResponseEntity<List<ApplyResponse>> findAllAppliesByMeetingId(@PathVariable("meegingId") Long meegingId) {
        List<ApplyResponse> applyResponseList = meetingService.findAllAppliesByMeetingId(meegingId);

        return ResponseEntity.ok(applyResponseList);
    }

    @PostMapping("{id}")
    public ResponseEntity<String> applyMeeting(@PathVariable("id") Long id,
                                               @Valid @RequestBody ApplyRequest applyRequest) {
        meetingService.applyMeeting(id, applyRequest);

        return ResponseEntity.ok("신청 완료");
    }

    @PatchMapping("{id}")
    public ResponseEntity<String> acceptApply(@PathVariable("id") Long id) {


        return ResponseEntity.ok("만남 성사");
    }
}
