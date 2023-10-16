package com.example.yeoreumjava.auth.repository;

import com.example.yeoreumjava.auth.domain.Authentication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Authentication,Long> {
    Optional<Authentication> findByUsernameAndHashedPassword(String username, String password);

    Optional<Authentication> findByUsername(String username);
}
