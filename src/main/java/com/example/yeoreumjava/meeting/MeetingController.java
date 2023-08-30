package com.example.yeoreumjava.meeting;

import com.example.yeoreumjava.board.domain.dto.BoardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/meetings")
public class MeetingController {
//    @GetMapping("{id}")
//    public ResponseEntity<List<BoardResponse>> findAll() {
//        List<BoardResponse> boardResponseList = boardService.findAll();
//
//        return ResponseEntity.ok(boardResponseList);
//    }
}
