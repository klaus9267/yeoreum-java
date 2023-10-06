package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.MeetingService;
import com.example.yeoreumjava.meeting.domain.Guest;
import com.example.yeoreumjava.meeting.domain.dto.GuestRequest;
import com.example.yeoreumjava.meeting.domain.dto.GuestResponse;
import com.example.yeoreumjava.profile.ProfileService;
import com.example.yeoreumjava.user.UserService;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MeetingService.class, ProfileService.class})
public interface GuestMapper extends BaseMapper<GuestRequest, GuestResponse, Guest> {
    GuestMapper instance = Mappers.getMapper(GuestMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    @Mapping(target = "profileId", expression = "java(entity.getProfile().getId())")
    GuestResponse toDto(Guest entity);

    @Named("D2E")
    @Mapping(target = "meeting", source = "meetingId", qualifiedByName = "loadMeeting")
    @Mapping(target = "profile", source = "profileId", qualifiedByName = "loadProfile")
    Guest toEntity(GuestRequest dto,
                   @Context ProfileService profileService,
                   @Context MeetingService meetingService);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<GuestResponse> toDtoList(List<Guest> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<Guest> toEntityList(List<GuestRequest> dtoList,
                             @Context ProfileService profileService,
                             @Context MeetingService meetingService);
}
