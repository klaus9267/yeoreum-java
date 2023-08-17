package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.BoardDto;
import com.example.yeoreumjava.board.mapper.BoardMapper;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.dto.HostDto;
import org.mapstruct.Context;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface HostMapper extends BaseMapper<HostDto, Host> {
    BoardMapper instance = Mappers.getMapper(BoardMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "place", source = "place")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "boardId", expression = "java(entity.getBoard().getId())")
    HostDto toDto(Host entity);

    @Named("D2EWI")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "place", source = "place")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "board", source = "boardId", qualifiedByName = "findBoardById")
    Host toEntity(HostDto dto, @Context BoardRepository boardRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<HostDto> toDtoList(List<Host> entityList);

    @IterableMapping(qualifiedByName = "D2EWI")
    List<Board> toEntityList(List<BoardDto> dtoList, @Context BoardRepository boardRepository);

    @Named("findHostById")
    default Board findHostById(Long id, @Context BoardRepository boardRepository) {
        return boardRepository.findBoardById(id);
    }
}
