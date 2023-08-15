package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;
    @Test
    void findBoardById() {
        Board board = boardRepository.findBoardById(1L);

        System.out.println(board.toString());
    }
}