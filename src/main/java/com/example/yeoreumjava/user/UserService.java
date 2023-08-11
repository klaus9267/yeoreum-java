package com.example.yeoreumjava.user;

import com.example.yeoreumjava.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public void createUser(User user) {
        System.out.println(user.getMajor());
        userRepository.save(user);
    }

    public void updateUser(Long id, User input) {
        User user = userRepository.findUserById(id);
        System.out.println(input.getMajor());

//        user.setNickname(input.getNickname());
//        user.setMajor(input.getMajor());

//        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
