package com.example.yeoreumjava.user;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.domain.Authority;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.LoginRequest;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final MeetingRepository meetingRepository;
    private final BoardRepository boardRepository;
    private final PasswordEncoder passwordEncoder;

    private final MajorService majorService;

    public User login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail())
                                  .orElseThrow(() -> new RuntimeException("email을 확인해 주세요."));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getHashedPassword())) {
            throw new RuntimeException("password를 확인해 주세요");
        }

        return user;
    }

    public void join(UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.getEmail()).isPresent()) {
            throw new RuntimeException("이미 가입된 사용자입니다.");
        }

        Authority authority = Authority.builder()
                                       .authorityName("ROLE_USER")
                                       .build();

        User user = User.builder()
                        .username(userRequest.getUsername())
                        .email(userRequest.getEmail())
                        .hashedPassword(passwordEncoder.encode(userRequest.getPassword()))
                        //                        .hashedPassword(userRequest.getPassword())
                        .authorities(Collections.singleton(authority))
                        .major(majorService.loadMajor(userRequest.getMajorId()))
                        .build();

        userRepository.save(user);
    }

    @org.mapstruct.Named("loadUser")
    public User loadUser(Long id) {
        return findUser(id).orElseThrow(() -> new NoSuchElementException(id + "번 사용자가 없습니다."));
    }

    public List<User> loadUserList(List<Long> idList) {
        return idList.stream().map(this::loadUser).collect(Collectors.toList());
    }

    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
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
