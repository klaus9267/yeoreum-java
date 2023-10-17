package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.auth.domain.Authority;
import com.example.yeoreumjava.major.domain.Major;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String hashedPassword;

    @Column(nullable = false)
    private boolean gender; // 1 : male, 2 : female

    @ManyToOne(fetch = FetchType.LAZY)
    private Major major;

    @ManyToMany
    @JoinTable(
            name = "users_authority",
            joinColumns = {@JoinColumn(name = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "authorityName")})
    private Set<Authority> authorities;
}
