package com.example.yeoreumjava.major.domain;

import com.example.yeoreumjava.user.domain.User;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "major_id")
    private List<User> users = new ArrayList<>();
}

