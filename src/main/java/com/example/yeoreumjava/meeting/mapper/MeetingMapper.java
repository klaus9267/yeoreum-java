package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.MeetingDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = BoardRepository.class)
public interface MeetingMapper extends BaseMapper<MeetingDto, Meeting> {
    MeetingMapper instance = Mappers.getMapper(MeetingMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "place", source = "place")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "boardId", expression = "java(entity.getBoard().getId())")
    MeetingDto toDto(Meeting entity);

    @Named("D2E")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "place", source = "place")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "board", source = "boardId", qualifiedByName = "findBoardById")
    Meeting toEntity(MeetingDto dto, @Context BoardRepository boardRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<MeetingDto> toDtoList(List<Meeting> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<Meeting> toEntityList(List<MeetingDto> dtoList, @Context BoardRepository boardRepository);
}
