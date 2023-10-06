package com.example.yeoreumjava.user;

import com.example.yeoreumjava.board.BoardService;
import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.meeting.MeetingService;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    private final MeetingService meetingService;
    private final BoardService boardService;
    private final MajorService majorService;

    @org.mapstruct.Named("loadUser")
    public User loadUser(Long id) {
        return findUser(id).orElseThrow(() -> new NoSuchElementException(id + "번 사용자가 없습니다."));
    }

    public List<User> loadUserList(List<Long> idList) {
        List<User> userList = new ArrayList<>();

        idList.forEach(id -> userList.add(loadUser(id)));

        return userList;
    }

    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(UserRequest userRequest) {
        User user = UserMapper.instance.toEntity(userRequest, majorService);

        return userRepository.save(user);
    }

    public User updateUser(Long id, UserRequest userRequest) {
        User user = UserMapper.instance.toEntity(userRequest, majorService);
        user.setId(id);

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        loadUser(id);

        List<Board> boardList = boardService.fi
        if (!boardList.isEmpty()) {
            boardList.forEach(board -> meetingRepository.deleteById(board.getMeeting().getId()));
        }

        userRepository.deleteById(id);
    }
}
