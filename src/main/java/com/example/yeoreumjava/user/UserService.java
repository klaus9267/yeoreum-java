package com.example.yeoreumjava.user;

import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.major.repository.MajorRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.domain.dto.UserResponse;
import com.example.yeoreumjava.user.mapper.UserMapper;
import com.example.yeoreumjava.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final MajorService majorService;

    public List<UserResponse> findAll() {
        List<User> userList = userRepository.findAll();

        return UserMapper.instance.toDtoList(userList);
    }

    public UserResponse findUserById(Long id) {
        User user = userRepository.findUserById(id);

        return UserMapper.instance.toDto(user);
    }

    public void createUser(UserRequest userRequest) {
        User user = UserMapper.instance.toEntity(userRequest);
//        User user = UserMapper.instance.toEntity(userRequest,majorService);

        userRepository.save(user);
    }

    public void updateUser(Long id, UserRequest userRequest) {
        User user = UserMapper.instance.toEntity(userRequest, majorService);
        user.setId(id);

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
