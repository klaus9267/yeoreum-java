package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.MeetingService;
import com.example.yeoreumjava.meeting.domain.Guest;
import com.example.yeoreumjava.meeting.domain.dto.GuestRequest;
import com.example.yeoreumjava.meeting.domain.dto.GuestResponse;
import com.example.yeoreumjava.user.UserService;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MeetingService.class, UserService.class})
public interface GuestMapper extends BaseMapper<GuestRequest, GuestResponse, Guest> {
    GuestMapper instance = Mappers.getMapper(GuestMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    @Mapping(target = "username", expression = "java(entity.getUser().getUsername())")
    GuestResponse toDto(Guest entity);
}
