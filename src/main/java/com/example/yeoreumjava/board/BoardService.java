package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.board.mapper.BoardMapper;
import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.meeting.MeetingService;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.MeetingRequest;
import com.example.yeoreumjava.meeting.mapper.MeetingMapper;
import com.example.yeoreumjava.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;

    private final MeetingService meetingService;
    private final UserService userService;

    public List<Board> loadBoardList(Long writerId) {
        return boardRepository.findAllByWriterId(writerId);
    }

    public Optional<Board> findBoard(Long id) {
        return boardRepository.findById(id);
    }

    @org.mapstruct.Named("loadBoard")
    public Board loadBoard(Long id) {
        return findBoard(id).orElseThrow(() -> new NoSuchElementException(id + "번 게시글이 없습니다."));
    }

    public Board createBoard(BoardRequest boardRequest) {
        MeetingRequest meetingRequest = MeetingMapper.instance.extractMeetingDto(boardRequest);
        Meeting meeting = meetingService.createMeeting(meetingRequest);

        Board board = BoardMapper.INSTANCE.toEntity(boardRequest);
        board.setMeeting(meeting);

        return boardRepository.save(board);
    }

    public void updateBoard(Long id, BoardRequest boardRequest) {
        loadBoard(id);

        Board board = BoardMapper.INSTANCE.toEntity(boardRequest);
        board.setId(id);

        boardRepository.save(board);
        MeetingRequest meetingRequest = MeetingMapper.instance.extractMeetingDto(boardRequest);
        meetingService.updateMeeting(id, meetingRequest);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
