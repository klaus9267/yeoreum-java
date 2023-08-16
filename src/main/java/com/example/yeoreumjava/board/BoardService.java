package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.BoardDTO;
import com.example.yeoreumjava.board.mapper.BoardMapper;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.meeting.MeetingRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MeetingRepository meetingRepository;

    public List<BoardDTO> findAll() {
        List<Board> boardList = boardRepository.findAll();

        return BoardMapper.INSTANCE.toDtoList(boardList);
    }

    public BoardDTO findBoardById(Long id) {
        Board board = boardRepository.findBoardById(id);

        return BoardMapper.INSTANCE.toDto(board);
    }

    public void createBoard(BoardDTO dto) {
        Board board = BoardMapper.INSTANCE.toEntity(dto);

        boardRepository.save(board);
    }

    public void updateBoard(Long id, BoardDTO boardDTO) {
        Board board = BoardMapper.INSTANCE.toEntity(boardDTO);
        board.setId(id);

        boardRepository.save(board);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
