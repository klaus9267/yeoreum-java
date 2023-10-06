package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.MeetingService;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.HostRequest;
import com.example.yeoreumjava.meeting.domain.dto.HostResponse;
import com.example.yeoreumjava.profile.ProfileService;
import com.example.yeoreumjava.profile.domain.Profile;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.domain.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
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

    default List<Host> setEntityList(List<Long> hostIdList, Meeting meeting, @Context ProfileService profileService) {
        List<Host> hostList = new ArrayList<>();

        hostIdList.forEach(hostId -> {
            Profile profile = profileService.loadProfile(hostId);
            Host host = Host.builder().meeting(meeting).profile(profile).build();

            hostList.add(host);
        });

        return hostList;
    }
}
