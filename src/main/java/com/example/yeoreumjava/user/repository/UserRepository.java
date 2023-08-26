package com.example.yeoreumjava.user.repository;

import com.example.yeoreumjava.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
}
