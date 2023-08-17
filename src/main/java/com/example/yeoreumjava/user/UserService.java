package com.example.yeoreumjava.user;

import com.example.yeoreumjava.major.repository.MajorRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDto;
import com.example.yeoreumjava.user.mapper.UserMapper;
import com.example.yeoreumjava.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final MajorRepository majorRepository;

    public List<UserDto> findAll() {
        List<User> userList = userRepository.findAll();

        return UserMapper.instance.toDtoList(userList);
    }

    public UserDto findUserById(Long id) {
        User user = userRepository.findUserById(id);

        return UserMapper.instance.toDto(user);
    }

    public void createUser(UserDto userDTO) {
        User user = UserMapper.instance.toEntity(userDTO, majorRepository);

        userRepository.save(user);
    }

    public void updateUser(Long id, UserDto userDTO) {
        User user = UserMapper.instance.toEntity(userDTO, majorRepository);
        user.setId(id);

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
