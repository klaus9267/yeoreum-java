package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.MeetingService;
import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.Guest;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.domain.dto.ApplyResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = MeetingService.class)
public interface ApplyMapper extends BaseMapper<ApplyRequest, ApplyResponse, Apply> {
    ApplyMapper instance = Mappers.getMapper(ApplyMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    @Mapping(target = "guestList", source = "guestList", qualifiedByName = "setGuestIdList")
    ApplyResponse toDto(Apply entity);

    @Named("D2E")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "content", source = "content")
    @Mapping(target = "meeting", source = "meetingId", qualifiedByName = "findMeetingById")
    @Mapping(target = "guestList", source = "guestList", qualifiedByName = "setGuestIdList")
    Apply toEntity(ApplyRequest dto, @Context MeetingService meetingService);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<ApplyResponse> toDtoList(List<Apply> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<Apply> toEntityList(List<ApplyRequest> dtoList, @Context MeetingService meetingService);

    @Named("setGuestIdList")
    default List<Long> setGuestList(List<Guest> guestList) {
        return guestList.stream().map(Guest::getId).toList();
    }
}
