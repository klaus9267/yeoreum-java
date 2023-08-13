package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.major.domain.Major;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Major major;

    @OneToMany
    @JsonIgnore
    @ToString.Exclude
    @JoinColumn(name = "writer_id")
    private final List<Board> boards = new ArrayList<>();
}
