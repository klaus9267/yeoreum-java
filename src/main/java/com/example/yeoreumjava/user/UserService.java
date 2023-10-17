package com.example.yeoreumjava.user;

import com.example.yeoreumjava.auth.domain.Authority;
import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final MeetingRepository meetingRepository;
    private final BoardRepository boardRepository;
    private final PasswordEncoder passwordEncoder;

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

    public void join(UserRequest userRequest) {
        if (userRepository.findByUsername(userRequest.getUsername()).isPresent()) {
            throw new RuntimeException("이미 가입된 사용자입니다.");
        }

        Authority authority = Authority.builder()
                                       .authorityName("ROLE_USER")
                                       .build();

        User user = User.builder()
                        .username(userRequest.getUsername())
                        .hashedPassword(passwordEncoder.encode(userRequest.getPassword()))
                        .authorities(Collections.singleton(authority))
                        .build();

        userRepository.save(user);
    }

    //    public User updateUser(Long id, UserRequest userRequest) {
    //        User user = UserMapper.instance.toEntity(userRequest);
    //        user.setId(id);
    //
    //        return userRepository.save(user);
    //    }

    public void deleteUser(Long id) {
        loadUser(id);

        List<Board> boardList = boardRepository.findAllByWriterId(id);
        if (!boardList.isEmpty()) {
            boardList.forEach(board -> meetingRepository.deleteById(board.getMeeting().getId()));
        }

        userRepository.deleteById(id);
    }
}
