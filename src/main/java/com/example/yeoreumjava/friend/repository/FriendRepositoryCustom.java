package com.example.yeoreumjava.friend.repository;

import com.example.yeoreumjava.friend.domain.Friend;
import com.example.yeoreumjava.user.domain.User;

import java.util.List;

public interface FriendRepositoryCustom {
    List<Friend> findAllByUser(User user);

    List<Friend> isFriend(User loginUser, User targetUser);
}
