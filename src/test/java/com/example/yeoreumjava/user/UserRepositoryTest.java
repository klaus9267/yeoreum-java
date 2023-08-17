package com.example.yeoreumjava.user;

import com.example.yeoreumjava.major.repository.MajorRepository;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDto;
import com.example.yeoreumjava.user.mapper.UserMapper;
import com.example.yeoreumjava.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

        UserDto userDTO = UserDto.builder().name("맞나").majorId(3L).build();

        User user = UserMapper.instance.toEntity(userDTO, majorRepository);


        System.out.println(user.toString());

        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void findAll() {
        List<User> userList = userRepository.findAll();

        System.out.println(UserMapper.instance.toDtoList(userList));
    }
}