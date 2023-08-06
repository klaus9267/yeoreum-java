package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
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
    public ResponseEntity<List<Board>> findBoardById() {
        List<Board> boards = boardService.findAll();

        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> findBoardById(@PathVariable("id") Long id) {
        Board board = boardService.findBoardById(id);

        return ResponseEntity.ok(board);
    }

    @PostMapping("")
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        boardService.createBoard(board);

        return ResponseEntity.ok(board);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable("id") Long id, @RequestBody Board board) {
        boardService.updateBoard(id,board);

        return ResponseEntity.ok(board);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMajor(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
    }
}
