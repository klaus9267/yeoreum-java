package com.example.yeoreumjava.user;

import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.repository.MajorRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.domain.dto.UserResponse;
import com.example.yeoreumjava.user.mapper.UserMapper;
import com.example.yeoreumjava.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired private UserRepository userRepository;

    @Autowired private MajorRepository majorRepository;

    @Test
    void createUser() {
        Major major = majorRepository.getById(5L);
        System.out.println(major.toString());
//        UserResponse userResponse = UserResponse.builder().name("맞나").majorId(3L).build();

        //        User user = UserMapper.instance.toEntity(userResponse, majorRepository);


        //        System.out.println(user.toString());
        //
        //        userRepository.save(user);
//        userRepository.findAll().forEach(System.out::println);
    }

    @Test
    void findAll() {
        List<User> userList = userRepository.findAll();

        System.out.println(UserMapper.instance.toDtoList(userList));
    }

    @Test
    void findUserByIds() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(6L);
        list.add(7L);
        System.out.println(list.toString());

        userRepository.findAllById(list).forEach(System.out::println);

    }
}