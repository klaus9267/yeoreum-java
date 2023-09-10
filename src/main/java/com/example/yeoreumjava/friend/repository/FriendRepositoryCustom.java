package com.example.yeoreumjava.friend.repository;

import com.example.yeoreumjava.friend.domain.Friend;

import java.util.List;

public interface FriendRepositoryCustom {
    List<Friend> findAllById(Long id);
}
