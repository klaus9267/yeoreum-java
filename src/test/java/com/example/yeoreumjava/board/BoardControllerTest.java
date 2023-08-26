package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardControllerTest {
    @Test
    void iterableMappingTest() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);

        BoardRequest boardRequest = BoardRequest.builder()
                                                .content("test conet")
                                                .time("아무때나")
                                                .title("아무거나")
                                                .writerId(1L)
                                                .hostList(list)
                                                .build();

        System.out.println(boardRequest.toString());
    }

}