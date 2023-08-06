package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
    Board findBoardById(Long id);
}
