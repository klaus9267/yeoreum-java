package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.board.repository.BoardRepository;
import com.example.yeoreumjava.board.mapper.BoardMapper;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.MeetingDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = BoardMapper.class)
public interface MeetingMapper extends BaseMapper<MeetingDto, Meeting> {
    MeetingMapper instance = Mappers.getMapper(MeetingMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "place", source = "place")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "boardId", expression = "java(entity.getBoard().getId())")
    MeetingDto toDto(Meeting entity);

    @Named("D2EWI")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "place", source = "place")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "board", source = "boardId", qualifiedByName = "findBoardById")
    Meeting toEntity(MeetingDto dto, @Context BoardRepository boardRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<MeetingDto> toDtoList(List<Meeting> entityList);

    @IterableMapping(qualifiedByName = "D2EWI")
    List<Meeting> toEntityList(List<MeetingDto> dtoList, @Context BoardRepository boardRepository);

    @Named("findMeetingById")
    default Meeting findMeetingById(Long id, @Context MeetingRepository meetingRepository) {
        return meetingRepository.findMeetingById(id);
    }
}
