package com.example.yeoreumjava.user;

import com.example.yeoreumjava.major.MajorRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDTO;
import com.example.yeoreumjava.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public UserDTO findUserById(Long id) {
        User user = userRepository.findUserById(id);

        return UserMapper.instance.toDto(user);
    }

    public void createUser(UserDTO userDTO) {
        User user = UserMapper.instance.toEntity(userDTO);

        userRepository.save(user);
    }

    public void updateUser(Long id, UserDTO userDTO) {
        User user = UserMapper.instance.toEntity(userDTO);
        user.setId(id);

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
