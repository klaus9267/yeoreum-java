package com.example.yeoreumjava.friend.repository;

import com.example.yeoreumjava.friend.domain.Friend;
import com.example.yeoreumjava.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface FriendCustomRepository {
    List<Friend> findAllByUser(User user);
    Optional<Friend> isFriend(User loginUser, User targetUser);

    void withdraw(Long userId);
}
