package com.example.yeoreumjava.board.repository;

import com.example.yeoreumjava.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
    Page<Board> findAllByWriterId(Pageable pageable);
}
