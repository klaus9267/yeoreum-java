package com.example.yeoreumjava.board.mapper;


import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.BoardDto;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = BoardMapper.class)
public interface BoardMapper extends BaseMapper<BoardDto, Board> {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Named("findBoardById")
    default Board findBoardById(Long id, @Context BoardRepository boardRepository) {
        return boardRepository.findBoardById(id);
    }
}
