package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.meeting.domain.dto.ApplyPagination;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.domain.dto.ApplyResponse;
import com.example.yeoreumjava.meeting.mapper.ApplyMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
@RequiredArgsConstructor
public class MeetingController {
    private final MeetingService meetingService;

    @GetMapping("{meetingId}/{page}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<ApplyPagination> findAllAppliesByMeetingId(@PathVariable("meetingId") Long meetingId,
                                                                           @PathVariable("page") int page) {
        return ResponseEntity.ok(ApplyMapper.instance.toPagination(meetingService.loadApplyList(meetingId, page)));
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<ApplyResponse> loadApply(@PathVariable("id") Long id) {
        return ResponseEntity.ok(ApplyMapper.instance.toDto(meetingService.loadApply(id)));
    }

    @PostMapping("{meetingId}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> applyMeeting(@PathVariable("meetingId") Long meetingId,
                                               @Valid @RequestBody ApplyRequest applyRequest) {
        meetingService.applyMeeting(meetingId, applyRequest);
        return ResponseEntity.ok("신청 완료");
    }

    @PatchMapping("{applyId}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> acceptApply(@PathVariable("applyId") Long applyId) {
        meetingService.acceptApply(applyId);
        return ResponseEntity.ok("만남 성사");
    }
}
