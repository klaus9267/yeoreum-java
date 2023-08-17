package com.example.yeoreumjava.user.repository;

import com.example.yeoreumjava.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findUserById(Long id);
}
