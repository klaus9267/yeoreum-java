package com.example.yeoreumjava.board.repository;

import com.example.yeoreumjava.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
    @org.mapstruct.Named("findBoardById")
    Board findBoardById(Long id);
}
