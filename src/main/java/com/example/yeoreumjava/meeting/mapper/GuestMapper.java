package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Guest;
import com.example.yeoreumjava.meeting.domain.dto.GuestRequest;
import com.example.yeoreumjava.meeting.domain.dto.GuestResponse;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.UserService;
import com.example.yeoreumjava.user.repository.UserRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MeetingRepository.class, UserService.class})
public interface GuestMapper extends BaseMapper<GuestRequest, GuestResponse, Guest> {
    GuestMapper instance = Mappers.getMapper(GuestMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    @Mapping(target = "userId", expression = "java(entity.getUser().getId())")
    GuestResponse toDto(Guest entity);

    @Named("D2E")
    @Mapping(target = "meeting", source = "meetingId", qualifiedByName = "findMeetingById")
    @Mapping(target = "user", source = "userId", qualifiedByName = "findUserById")
    Guest toEntity(GuestRequest dto,
                   @Context UserRepository userRepository,
                   @Context MeetingRepository meetingRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<GuestResponse> toDtoList(List<Guest> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<Guest> toEntityList(List<GuestRequest> dtoList,
                             @Context UserRepository userRepository,
                             @Context MeetingRepository meetingRepository);
}
