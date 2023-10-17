package com.example.yeoreumjava.user.domain;

import com.example.yeoreumjava.major.domain.Major;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
