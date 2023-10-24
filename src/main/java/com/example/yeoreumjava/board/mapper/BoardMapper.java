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
    @Mapping(target = "writerId", expression = "java(entity.getWriter().getId())")
    @Mapping(target = "hostList", expression = "java(entity.getMeeting().getHostList())")
    @Mapping(target = "applyList", expression = "java(entity.getMeeting().getApplyList())")
    BoardResponse toDto(Board entity);

//    @Named("D2E")
//    @Mapping(target = "writer", ignore = true)
//    @Mapping(target = "meeting", ignore = true)
//    Board toEntity(BoardRequest dto);
}
