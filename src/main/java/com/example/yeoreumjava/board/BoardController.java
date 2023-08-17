package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.BoardDto;
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
    public ResponseEntity<List<BoardDto>> findBoardById() {
        List<BoardDto> boardDtoList = boardService.findAll();

        return ResponseEntity.ok(boardDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardDto> findBoardById(@PathVariable("id") Long id) {
        BoardDto board = boardService.findBoardById(id);

        return ResponseEntity.ok(board);
    }

    @PostMapping("")
    public ResponseEntity<BoardDto> createBoard(@RequestBody BoardDto boardDTO) {
        boardService.createBoard(boardDTO);

        return ResponseEntity.ok(boardDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BoardDto> updateBoard(@PathVariable("id") Long id, @RequestBody BoardDto boardDTO) {
        boardService.updateBoard(id,boardDTO);

        return ResponseEntity.ok(boardDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMajor(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);

        return ResponseEntity.status(HttpStatus.OK).body("삭제 성공");
    }
}
