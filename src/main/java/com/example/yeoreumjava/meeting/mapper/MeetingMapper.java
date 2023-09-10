package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.MeetingRequest;
import com.example.yeoreumjava.meeting.domain.dto.MeetingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MeetingMapper extends BaseMapper<MeetingRequest, MeetingResponse, Meeting> {
    MeetingMapper instance = Mappers.getMapper(MeetingMapper.class);

    @Override
    @Mapping(target = "hostList",ignore = true)
    Meeting toEntity(MeetingRequest dto);

    @Mapping(target = "place", source = "place")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "hostList", ignore = true)
    Meeting extractMeeting(BoardRequest boardRequest);

    @Mapping(target = "place", source = "place")
    @Mapping(target = "time", source = "time")
    @Mapping(target = "hostList", source = "hostList")
    MeetingRequest extractMeetingDto(BoardRequest boardRequest);
}
