package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.major.domain.Major;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nickname;


    @ManyToOne(fetch = FetchType.LAZY)
    private Major major;

    @OneToMany
    @ToString.Exclude // ToString 시 해당 컬럼 출력 해제
    @JoinColumn(name = "writer_id")
    private List<Board> boards = new ArrayList<>();
}
