package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    public String getAllBoards() {
        return "hi";
    }

}
