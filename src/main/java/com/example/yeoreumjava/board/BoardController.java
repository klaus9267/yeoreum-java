package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.board.domain.dto.BoardResponse;
import com.example.yeoreumjava.board.mapper.BoardMapper;
import com.example.yeoreumjava.meeting.MeetingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    private final MeetingService meetingService;

    @GetMapping("/my/{id}")
    public ResponseEntity<List<BoardResponse>> loadBoardList(@PathVariable("id") Long id) {
        return ResponseEntity.ok(BoardMapper.INSTANCE.toDtoList(boardService.loadBoardList(id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> loadBoard(@PathVariable("id") Long id) {
        return ResponseEntity.ok(BoardMapper.INSTANCE.toDto(boardService.loadBoard(id)));
    }

    @PostMapping("")
    public ResponseEntity<BoardResponse> createBoard(@Valid @RequestBody BoardRequest boardRequest) {
        // boardReq에 작성자 번호 삽입
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(BoardMapper.INSTANCE.toDto(boardService.createBoard(boardRequest)));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable("id") Long id, @RequestBody BoardRequest boardRequest) {
        boardService.updateBoard(id, boardRequest);
        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok("삭제 성공");
    }
}
