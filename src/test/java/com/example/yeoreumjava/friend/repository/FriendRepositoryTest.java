package com.example.yeoreumjava.friend.repository;

import com.example.yeoreumjava.friend.domain.Friend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FriendRepositoryTest {
@Autowired
FriendRepository friendRepository;
    @Test

    void findBySenderIdAndReceiverId() {
        Friend friend = friendRepository.findBySenderIdAndReceiverId(1L, 2L).orElseThrow(RuntimeException::new);
        System.out.println("friend : " + friend);
    }
}