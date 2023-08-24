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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MeetingService meetingService;

    public List<BoardResponse> findAll() {
        List<Board> boardList = boardRepository.findAll();

        return BoardMapper.INSTANCE.toDtoList(boardList);
    }

    public BoardResponse findBoardResponseById(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(()->new NoSuchElementException(id+"번 게시글이 없습니다."));

        return BoardMapper.INSTANCE.toDto(board);
    }

    @org.mapstruct.Named("findBoardById")
    public Board findBoardById(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 게시글이 없습니다."));
    }

    public void createBoard(BoardRequest boardRequest) {
        MeetingRequest meetingRequest = MeetingMapper.instance.extractMeetingDto(boardRequest);
        Meeting meeting = meetingService.createMeeting(meetingRequest);

        Board board = BoardMapper.INSTANCE.toEntity(boardRequest);
        board.setMeeting(meeting);

        boardRepository.save(board);
    }

    public void updateBoard(Long id, BoardRequest boardRequest) {
        boardRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "번 게시글이 없습니다."));
        Board board = BoardMapper.INSTANCE.toEntity(boardRequest);
        board.setId(id);

        boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
