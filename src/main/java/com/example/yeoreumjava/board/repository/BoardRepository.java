package com.example.yeoreumjava.board.repository;

import com.example.yeoreumjava.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    Page<Board> findAllByWriterId(Long userId,Pageable pageable);
    List<Board> findAllByWriterId(Long userId);
}
