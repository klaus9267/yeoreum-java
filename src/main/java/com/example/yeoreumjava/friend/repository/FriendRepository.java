package com.example.yeoreumjava.friend.repository;

import com.example.yeoreumjava.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.yeoreumjava.friend.domain.Friend;

import java.util.Optional;

public interface FriendRepository extends JpaRepository<Friend, Long> {
    Optional<Friend> findBySenderAndReceiver(User sender, User receiver);
}
