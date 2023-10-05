package com.example.yeoreumjava.board.mapper;


import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.board.domain.dto.BoardResponse;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.user.UserService;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserService.class})
public interface BoardMapper extends BaseMapper<BoardRequest, BoardResponse, Board> {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "writerId", expression = "java(entity.getWriter().getId())")
    BoardResponse toDto(Board entity);

    @Named("D2E")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "writer", ignore = true)
    Board toEntity(BoardRequest dto);
}
