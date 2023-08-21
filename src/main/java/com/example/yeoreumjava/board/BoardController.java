package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.board.domain.dto.BoardResponse;
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

    @GetMapping("")
    public ResponseEntity<List<BoardResponse>> findBoardById() {
        List<BoardResponse> boardResponseList = boardService.findAll();

        return ResponseEntity.ok(boardResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> findBoardById(@PathVariable("id") Long id) {
        BoardResponse board = boardService.findBoardResponseById(id);

        return ResponseEntity.ok(board);
    }

    @PostMapping("")
    public ResponseEntity<String> createBoard(@RequestBody BoardRequest boardRequest) {
        boardService.createBoard(boardRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body("작성 완료");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> updateBoard(@PathVariable("id") Long id, @RequestBody
    BoardRequest boardRequest) {
        boardService.updateBoard(id, boardRequest);

        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMajor(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);

        return ResponseEntity.ok("삭제 성공");
    }
}
