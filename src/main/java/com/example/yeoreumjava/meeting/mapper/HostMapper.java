package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.dto.HostRequest;
import com.example.yeoreumjava.meeting.domain.dto.HostResponse;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.repository.UserRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MeetingRepository.class, UserRepository.class})
public interface HostMapper extends BaseMapper<HostRequest, HostResponse, Host> {
    HostMapper instance = Mappers.getMapper(HostMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    @Mapping(target = "userId", expression = "java(entity.getUser().getId())")
    HostResponse toDto(Host entity);

    @Named("D2E")
    @Mapping(target = "meeting", source = "meetingId", qualifiedByName = "findMeetingById")
    @Mapping(target = "user", source = "userId", qualifiedByName = "findUserById")
    Host toEntity(HostRequest dto,
                  @Context UserRepository userRepository,
                  @Context MeetingRepository meetingRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<HostResponse> toDtoList(List<Host> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<Host> toEntityList(List<HostRequest> dtoList,
                            @Context UserRepository userRepository,
                            @Context MeetingRepository meetingRepository);
}
