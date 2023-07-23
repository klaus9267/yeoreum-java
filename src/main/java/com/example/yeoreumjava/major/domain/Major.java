package com.example.yeoreumjava.major.domain;

import com.example.yeoreumjava.user.domain.User;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@ToString
public class Major {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    private List<User> user=new ArrayList<>();
}

