package com.example.yeoreumjava.user.repository;

import com.example.yeoreumjava.user.domain.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);

    @NotNull
    Page<User> findAll(@NotNull Pageable pageable);
}
