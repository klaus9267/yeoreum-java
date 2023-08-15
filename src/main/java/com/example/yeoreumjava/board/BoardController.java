package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.BoardDTO;
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
    public ResponseEntity<List<BoardDTO>> findBoardById() {
        List<BoardDTO> boards = boardService.findAll();

        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDTO> findBoardById(@PathVariable("id") Long id) {
        BoardDTO board = boardService.findBoardById(id);

        return ResponseEntity.ok(board);
    }

    @PostMapping("")
    public ResponseEntity<BoardDTO> createBoard(@RequestBody BoardDTO boardDTO) {
        boardService.createBoard(boardDTO);

        return ResponseEntity.ok(boardDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BoardDTO> updateBoard(@PathVariable("id") Long id, @RequestBody BoardDTO boardDTO) {
        boardService.updateBoard(id,boardDTO);

        return ResponseEntity.ok(boardDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMajor(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
    }
}
