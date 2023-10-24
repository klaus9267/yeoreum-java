package com.example.yeoreumjava.board.repository;

import  com.example.yeoreumjava.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long> {
    Optional<List<Board>> findAllByWriterId(Long id);
}
