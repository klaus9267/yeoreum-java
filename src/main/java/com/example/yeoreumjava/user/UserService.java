package com.example.yeoreumjava.user;

import com.example.yeoreumjava.major.MajorRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final MajorRepository majorRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public void createUser(UserDTO userDTO) {
        User user = userDTO.toEntity();

//        userRepository.save(user);
    }

    public void updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findUserById(id);
//        System.out.println(userDTO.getMajorId());

        //        user.setNickname(input.getNickname());
        //        user.setMajor(input.getMajor());

        //        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
