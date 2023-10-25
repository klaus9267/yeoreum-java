package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.board.domain.dto.BoardResponse;
import com.example.yeoreumjava.board.mapper.BoardMapper;
import com.example.yeoreumjava.user.domain.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/my")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<List<BoardResponse>> loadMyBoardList(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(BoardMapper.INSTANCE.toDtoList(boardService.loadMyBoardList(user.getId())));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<BoardResponse> loadBoard(@PathVariable("id") Long id) {
        return ResponseEntity.ok(BoardMapper.INSTANCE.toDto(boardService.loadBoard(id)));
    }

    @PostMapping("")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> createBoard(@Valid @RequestBody BoardRequest boardRequest,
                                              @AuthenticationPrincipal User user) {
        boardService.createBoard(boardRequest, user);
        return ResponseEntity.ok("작성 완료");
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> updateBoard(@PathVariable("id") Long id, @RequestBody BoardRequest boardRequest) {
        boardService.updateBoard(id, boardRequest);
        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.ok("삭제 완료");
    }
}
