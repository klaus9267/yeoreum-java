package com.example.yeoreumjava.user;

import com.example.yeoreumjava.major.MajorRepository;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDTO;
import com.example.yeoreumjava.user.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MajorRepository majorRepository;

    @Test
    void createUser() {
        Major major = majorRepository.findMajorById(1L);

        UserDTO userDTO = UserDTO.builder()
                                 .name("맞나")
                                 .major(major)
                                 .build();

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        System.out.println(user.toString());

        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);

    }
}