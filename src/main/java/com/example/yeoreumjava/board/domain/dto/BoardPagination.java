package com.example.yeoreumjava.board.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class BoardPagination {
    List<BoardResponse> boardResponseList = new ArrayList<>();

    private int page;
    private int totalPage;
    private long totalElements;
}
