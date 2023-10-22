package com.example.yeoreumjava.friend;

import com.example.yeoreumjava.friend.repository.FriendCustomRepository;
import com.example.yeoreumjava.friend.repository.FriendRepository;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FriendServiceTest {
    @Autowired
    FriendRepository friendRepository;
    @Autowired
    FriendCustomRepository friendCustomRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    FriendService friendService;
    @Autowired
    UserService userService;

    @BeforeEach
    public void setUser() {
        String ps = passwordEncoder.encode("1111");
        UserRequest user1 = UserRequest.builder()
                                       .major("컴소")
                                       .username("유저1")
                                       .email("test@test.com")
                                       .password("1111")
                                       .build();
        UserRequest user2 = UserRequest.builder()
                                       .major("컴소ss")
                                       .username("유저2")
                                       .email("test2@test.com")
                                       .password("1111")
                                       .build();
        userService.join(user1);
        userService.join(user2);

        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void loadFriendList() {
    }

    @Test
    @Transactional
    void applyFriend() {
        User user1 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        User user2 = userRepository.findById(2L).orElseThrow(RuntimeException::new);

        System.out.println("before method!!");
        friendRepository.findAll().forEach(System.out::println);

        friendService.applyFriend(user1.getId(), user2.getId());

        System.out.println("after method!!");
        friendRepository.findAll().forEach(System.out::println);
    }

    @Test
    @Transactional
    void acceptFriend() {
        User user1 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        User user2 = userRepository.findById(2L).orElseThrow(RuntimeException::new);

        friendService.applyFriend(user1.getId(), user2.getId());
        friendService.acceptFriend(user1.getId(), user2.getId());

        friendRepository.findAll().forEach(System.out::println);
    }

    @Test
    void deleteFriend() {
    }

    @Test
    void findOne() {
    }
}