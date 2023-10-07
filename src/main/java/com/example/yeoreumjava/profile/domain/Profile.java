package com.example.yeoreumjava.profile.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.user.domain.User;
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
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Major major;

    @OneToMany(mappedBy = "writer",cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private User user;

    public void updateProfile(String name, Major major) {
        this.name = name;
        this.major = major;
    }
}
