package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.dto.BoardResponse;
import com.example.yeoreumjava.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;
    @Test
    void findBoardById() {
        Board board = boardRepository.getReferenceById(1L);

        System.out.println(board.toString());
    }

    @Test
    void createBoard() {
        BoardResponse boardResponse = BoardResponse.builder().writerId(1L).title("ssss").content("asdasd").build();
//        System.out.println(BoardMapper.INSTANCE.);
    }
}