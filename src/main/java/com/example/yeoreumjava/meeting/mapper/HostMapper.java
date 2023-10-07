package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.MeetingService;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.HostRequest;
import com.example.yeoreumjava.meeting.domain.dto.HostResponse;
import com.example.yeoreumjava.profile.ProfileService;
import com.example.yeoreumjava.profile.domain.Profile;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MeetingService.class, ProfileService.class})

public interface HostMapper extends BaseMapper<HostRequest, HostResponse, Host> {
    HostMapper instance = Mappers.getMapper(HostMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    @Mapping(target = "profileId", expression = "java(entity.getProfile().getId())")
    HostResponse toDto(Host entity);

    @Named("D2E")
    @Mapping(target = "meeting", source = "meetingId", qualifiedByName = "loadMeeting")
    @Mapping(target = "profile", source = "profileId", qualifiedByName = "loadProfile")
    Host toEntity(HostRequest dto, @Context ProfileService profileService, @Context MeetingService meetingService);

    @IterableMapping(qualifiedByName = "D2E")
    List<Host> toEntityList(List<HostRequest> dtoList,
                            @Context ProfileService profileService,
                            @Context MeetingService meetingService);

    default List<Host> setHostList(List<Profile> profileList, Meeting meeting) {
        return profileList.stream().map(profile -> Host.builder().meeting(meeting).profile(profile).build()).toList();
    }
}
