package com.example.yeoreumjava.board.mapper;


import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.BoardDto;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.repository.UserRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserRepository.class, MeetingRepository.class})
public interface BoardMapper extends BaseMapper<BoardDto, Board> {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "writerId", expression = "java(entity.getWriter().getId())")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    BoardDto toDto(Board entity);

    @Named("D2E")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "writer", source = "writerId", qualifiedByName = "findUserById")
    @Mapping(target = "meeting", source = "meetingId", qualifiedByName = "findMeetingById")
    Board toEntity(BoardDto dto,
                   @Context UserRepository userRepository,
                   @Context MeetingRepository meetingRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<BoardDto> toDtoList(List<Board> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<Board> toEntityList(List<BoardDto> dtoList,
                             @Context UserRepository userRepository,
                             @Context MeetingRepository meetingRepository);
}
