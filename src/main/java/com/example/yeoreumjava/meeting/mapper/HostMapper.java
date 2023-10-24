package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.MeetingService;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.HostRequest;
import com.example.yeoreumjava.meeting.domain.dto.HostResponse;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MeetingService.class, UserService.class})

public interface HostMapper extends BaseMapper<HostRequest, HostResponse, Host> {
    HostMapper instance = Mappers.getMapper(HostMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    @Mapping(target = "username", expression = "java(entity.getUser().getUsername())")
    HostResponse toDto(Host entity);

    @Named("D2E")
    @Mapping(target = "meeting", source = "meetingId", qualifiedByName = "loadMeeting")
    @Mapping(target = "user", source = "userId", qualifiedByName = "loadUser")
    Host toEntity(HostRequest dto, @Context UserService userService, @Context MeetingService meetingService);

    @IterableMapping(qualifiedByName = "D2E")
    List<Host> toEntityList(List<HostRequest> dtoList,
                            @Context UserService userService,
                            @Context MeetingService meetingService);
}
