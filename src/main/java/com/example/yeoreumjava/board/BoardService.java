package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.board.domain.dto.BoardResponse;
import com.example.yeoreumjava.board.mapper.BoardMapper;
import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.meeting.MeetingService;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;

    private final MeetingService meetingService;
    private final UserService userService;

    public List<Board> loadMyBoardList(Long userId) {
        List<Board> boardList = boardRepository.findAllByWriterId(userId)
                                               .orElseThrow(() -> new NoSuchElementException("게시글이 없습니다."));
//        boardList.forEach(System.out::println);
        BoardMapper.INSTANCE.toDtoList(boardList).forEach(System.out::println);
        return  boardList;

    }

    public Optional<Board> findBoard(Long id) {
        return boardRepository.findById(id);
    }

    @org.mapstruct.Named("loadBoard")
    public Board loadBoard(Long id) {
        return findBoard(id).orElseThrow(() -> new NoSuchElementException(id + "번 게시글이 없습니다."));
    }

    public void createBoard(BoardRequest boardRequest, User user) {
        boardRequest.getHostList().add(user.getId());
        Meeting meeting = meetingService.createMeeting(boardRequest);
        boardRepository.save(Board.builder()
                                  .title(boardRequest.getTitle())
                                  .content(boardRequest.getContent())
                                  .writer(user)
                                  .meeting(meeting)
                                  .build());
    }

    public void updateBoard(Long id, BoardRequest boardRequest) {
        Board board = loadBoard(id);
        board.updateBoard(boardRequest.getTitle(), boardRequest.getContent());
        boardRepository.save(board);

        meetingService.updateMeeting(board.getMeeting().getId(), boardRequest);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}


