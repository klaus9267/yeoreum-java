package com.example.yeoreumjava.friend.repository;

import com.example.yeoreumjava.friend.domain.Friend;
import com.example.yeoreumjava.user.domain.User;

import java.util.List;

public interface FriendRepositoryCustom {
    List<Friend> findAllById(User user);
}
