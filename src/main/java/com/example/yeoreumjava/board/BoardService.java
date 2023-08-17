package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.BoardDto;
import com.example.yeoreumjava.board.mapper.BoardMapper;
import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MeetingRepository meetingRepository;

    public List<BoardDto> findAll() {
        List<Board> boardList = boardRepository.findAll();

        return BoardMapper.INSTANCE.toDtoList(boardList);
    }

    public BoardDto findBoardById(Long id) {
        Board board = boardRepository.findBoardById(id);

        return BoardMapper.INSTANCE.toDto(board);
    }

    public void createBoard(BoardDto dto) {
        Board board = BoardMapper.INSTANCE.toEntity(dto);

        boardRepository.save(board);
    }

    public void updateBoard(Long id, BoardDto boardDTO) {
        Board board = BoardMapper.INSTANCE.toEntity(boardDTO);
        board.setId(id);

        boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
