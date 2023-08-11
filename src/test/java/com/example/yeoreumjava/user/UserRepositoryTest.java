package com.example.yeoreumjava.user;

import com.example.yeoreumjava.major.MajorRepository;
import com.example.yeoreumjava.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MajorRepository majorRepository;

    @Test
    void createUser(){
        User user = new User();

        user.setNickname("test");
        user.setMajor(majorRepository.findMajorById(1L));
        System.out.println(majorRepository.findMajorById(1L));

        userRepository.save(user);
    }
}