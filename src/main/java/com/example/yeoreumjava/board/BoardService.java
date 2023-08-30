package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.board.domain.dto.BoardResponse;
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

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class BoardService {
    private final BoardRepository boardRepository;
    private final MeetingService meetingService;
    private final UserService userService;

    public List<BoardResponse> findAll() {
        List<Board> boardList = boardRepository.findAll();

        return BoardMapper.INSTANCE.toDtoList(boardList);
    }

    public BoardResponse findBoardResponseById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 게시글이 없습니다."));

        return BoardMapper.INSTANCE.toDto(board);
    }

    @org.mapstruct.Named("findBoardById")
    public Board findBoardById(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 게시글이 없습니다."));
    }

    public void createBoard(BoardRequest boardRequest) {
        MeetingRequest meetingRequest = MeetingMapper.instance.extractMeetingDto(boardRequest);
        Meeting meeting = meetingService.createMeeting(meetingRequest);

        Board board = BoardMapper.INSTANCE.toEntity(boardRequest, userService);
        board.setMeeting(meeting);
        boardRepository.save(board);
    }

    public void updateBoard(Long id, BoardRequest boardRequest) {
        findBoardById(id);

        Board board = BoardMapper.INSTANCE.toEntity(boardRequest, userService);
        board.setId(id);

        boardRepository.save(board);

        MeetingRequest meetingRequest = MeetingMapper.instance.extractMeetingDto(boardRequest);
        meetingService.updateMeeting(id, meetingRequest);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
