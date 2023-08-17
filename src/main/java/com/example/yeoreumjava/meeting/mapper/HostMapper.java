package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.HostDto;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.repository.UserRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HostMapper extends BaseMapper<HostDto, Host> {
    HostMapper instance = Mappers.getMapper(HostMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    @Mapping(target = "userId", expression = "java(entity.getUser().getId())")
    HostDto toDto(Host entity);

    @Named("D2E")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "meeting", source = "meetingId", qualifiedByName = "findMeetingById")
    @Mapping(target = "user", source = "userId", qualifiedByName = "findUserById")
    Host toEntity(HostDto dto,
                  @Context UserRepository userRepository,
                  @Context MeetingRepository meetingRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<HostDto> toDtoList(List<Host> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<Host> toEntityList(List<HostDto> dtoList,
                            @Context UserRepository userRepository,
                            @Context MeetingRepository meetingRepository);

    @Named("findMeetingById")
    default Meeting findMeetingById(Long id, @Context MeetingRepository meetingRepository) {
        return meetingRepository.findMeetingById(id);
    }

    @Named("findUserById")
    default User findUserById(Long id, @Context UserRepository userRepository) {
        return userRepository.findUserById(id);
    }
}
