package com.example.yeoreumjava.board;

import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.meeting.MeetingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final MeetingRepository meetingRepository;

    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    public Board findBoardById(Long id) {
        return boardRepository.findBoardById(id);
    }

    public void createBoard(Board board) {
        boardRepository.save(board);
    }

    public void updateBoard(Long id, Board newBoard) {
        Board preBoard = boardRepository.findBoardById(id);
        newBoard.setId(preBoard.getId());

        boardRepository.save(newBoard);
    }

    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
