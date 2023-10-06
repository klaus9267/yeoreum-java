package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.MeetingRequest;
import com.example.yeoreumjava.meeting.domain.dto.MeetingResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeetingMapper extends BaseMapper<MeetingRequest, MeetingResponse, Meeting> {
    MeetingMapper instance = Mappers.getMapper(MeetingMapper.class);

    @Override
    @Named("E2D")
    MeetingResponse toDto(Meeting entity);

    @Override
    @Named("D2E")
    @Mapping(target = "hostList", ignore = true)
    Meeting toEntity(MeetingRequest dto);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<MeetingResponse> toDtoList(List<Meeting> entityList);

    @Override
    @IterableMapping(qualifiedByName = "D2E")
    List<Meeting> toEntityList(List<MeetingRequest> dtoList);

    @Mapping(target = "place", source = "place")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "hostList", ignore = true)
    MeetingRequest extractMeetingDto(BoardRequest boardRequest);
}
