package com.example.yeoreumjava.board.repository;

import  com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findAllByWriterId(Long id);
}
