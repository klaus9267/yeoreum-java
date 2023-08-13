package com.example.yeoreumjava.user;

import com.example.yeoreumjava.major.MajorRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MajorRepository majorRepository;

    @Test
    void createUser() {
        UserDTO userDTO = UserDTO.builder()
                                 .name("test")
                                 .major(majorRepository.findMajorById(1L))
                                 .build();
//        System.out.println(">>> : " + userDTO);

        User user = userDTO.toEntity();
        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
//        User user = User.builder()

//        System.out.println(">>> : " + user.toString());

    }
}