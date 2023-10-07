package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.profile.domain.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
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
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private Profile profile;

    public void updatePassword(String password) {
        this.password = password;
    }
}
