package com.example.yeoreumjava.friend.repository;

import com.example.yeoreumjava.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.yeoreumjava.friend.domain.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}
