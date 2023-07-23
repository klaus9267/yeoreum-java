package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.major.domain.Major;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue
    private Long no;

    @Column(nullable = false)
    private String nickname;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "major_no")
    private Major majorNo;

    @OneToMany
    @JoinColumn(name = "board_no")
    private List<Board> boards = new ArrayList<>();
}
