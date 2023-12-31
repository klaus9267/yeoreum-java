package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.common.constant.PageConstant;
import com.example.yeoreumjava.meeting.MeetingService;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Page<Board> loadMyBoardList(Long userId, int page) {
        PageRequest pageRequest = PageRequest.of(page, PageConstant.BOARD_SIZE);
        Page<Board> boardList = boardRepository.findAllByWriterId(userId, pageRequest);
        if (boardList.isEmpty()) {
            throw new NoSuchElementException("작성한 게시글이 없습니다.");
        }

        return boardList;
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

    public void updateBoard(Long id, BoardRequest boardRequest, User user) {
        Board board = loadBoard(id);

        if (!board.getWriter().getId().equals(user.getId())) {
            throw new RuntimeException("작성자가 아닙니다.");
        }

        board.updateBoard(boardRequest.getTitle(), boardRequest.getContent());
        boardRepository.save(board);

        boardRequest.getHostList().add(user.getId());
        meetingService.updateMeeting(board.getMeeting(), boardRequest);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}


