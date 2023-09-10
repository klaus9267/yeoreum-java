package com.example.yeoreumjava.user;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.domain.dto.UserResponse;
import com.example.yeoreumjava.user.mapper.UserMapper;
import com.example.yeoreumjava.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final MajorService majorService;
    private final MeetingRepository meetingRepository;
    private final BoardRepository boardRepository;

    public List<UserResponse> findAll() {
        List<User> userList = userRepository.findAll();

        return UserMapper.instance.toDtoList(userList);
    }

    public UserResponse findUserResponseById(Long id) {
        User user = findUserById(id);

        return UserMapper.instance.toDto(user);
    }

    public List<User> findUsersByIds(List<Long> idList) {
        List<User> userList = new ArrayList<>();

        idList.forEach(
                id -> {
                    User user = userRepository.findById(id)
                                              .orElseThrow(() -> new NoSuchElementException(id + "번 사용자가 없습니다."));
                    userList.add(user);
                });

        return userList;
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

        List<Board> boardList = boardRepository.findAllByWriterId(id);
        if (!boardList.isEmpty()) {
            boardList.forEach(board -> meetingRepository.deleteById(board.getMeeting().getId()));
        }

        userRepository.deleteById(id);
    }
}
