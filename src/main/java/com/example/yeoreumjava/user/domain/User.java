package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.meeting.domain.Host;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jsonwebtoken.Claims;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String hashedPassword;

    @ColumnDefault("true")
    private boolean gender; // 1 : male, 2 : female

    @Column(nullable = false)
    private String major;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    private List<Board> boardList = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "users_authority",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "authorityName")})
    private Set<Authority> authorities;

    public User(Claims claims) {
        this.id = Long.valueOf(claims.get("userId").toString());
        this.username = claims.get("username").toString();
    }

    public void updateUser(String username, String major) {
        this.username = username;
        this.major = major;
    }
}
