package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.major.domain.Major;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;


    @ManyToOne(fetch = FetchType.LAZY)
    private Major major;

    @OneToMany
    @JoinColumn(name = "writer_id")
    private List<Board> boards = new ArrayList<>();
}
