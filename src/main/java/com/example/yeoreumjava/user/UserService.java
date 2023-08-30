package com.example.yeoreumjava.user;

import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.domain.dto.UserResponse;
import com.example.yeoreumjava.user.mapper.UserMapper;
import com.example.yeoreumjava.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

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

    public UserResponse findUserResponseById(Long id) {
        User user = findUserById(id);

        return UserMapper.instance.toDto(user);
    }

    public List<User> findUsersByIds(List<Long> idList) {
        return userRepository.findAllById(idList);
    }

    @org.mapstruct.Named("findUserById")
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 사용자가 없습니다."));
    }

    public void createUser(UserRequest userRequest) {
        User user = UserMapper.instance.toEntity(userRequest, majorService);

        userRepository.save(user);
    }

    public void updateUser(Long id, UserRequest userRequest) {
        User user = UserMapper.instance.toEntity(userRequest, majorService);
        user.setId(id);

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        findUserById(id);

        userRepository.deleteById(id);
    }
}
