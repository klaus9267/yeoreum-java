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
        Major major = majorRepository.findMajorById(3L);
        System.out.println(major.toString());

        UserDTO userDTO = UserDTO.builder()
                                 .name("맞나")
                                 .majorId(3L)
                                 .build();

        User user = UserMapper.instance.toEntity(userDTO, majorRepository);


        System.out.println(user.toString());

        userRepository.save(user);
        userRepository.findAll()
                      .forEach(System.out::println);
    }
}