package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
class BoardServiceTest {

    @Test
    void createBoard() {
        BoardRequest boardRequest = BoardRequest.builder()
                                                .title("타이틀입니다.")
                                                .content("내용입니다.")
                                                .place("어디서만날까요.")
                                                .time("언제만날까.")
                                                .writerId(1L)
                                                .build();

        System.out.println("boardREQ : " + boardRequest);
    }
}