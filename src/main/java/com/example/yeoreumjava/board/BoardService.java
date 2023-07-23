package com.example.yeoreumjava.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    public String getAllBoards() {
        return "hi";
    }

}
