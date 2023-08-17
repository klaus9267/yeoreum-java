package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Guest;
import com.example.yeoreumjava.meeting.domain.dto.GuestDto;
import com.example.yeoreumjava.meeting.repository.MeetingRepository;
import com.example.yeoreumjava.user.mapper.UserMapper;
import com.example.yeoreumjava.user.repository.UserRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = {UserMapper.class, MeetingMapper.class})

public interface GuestMapper extends BaseMapper<GuestDto, Guest> {
    GuestMapper instance = Mappers.getMapper(GuestMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", expression = "java(entity.getUser().getId())")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    GuestDto toDto(Guest entity);

    @Named("D2EWI")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "user", source = "userId", qualifiedByName = "findUserById")
    @Mapping(target = "meeting", source = "meetingId", qualifiedByName = "findMeetingById")
    Guest toEntity(GuestDto dto,
                   @Context UserRepository userRepository,
                   @Context MeetingRepository meetingRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<GuestDto> toDtoList(List<Guest> entityList);

    @IterableMapping(qualifiedByName = "D2EWI")
    List<Guest> toEntityList(List<GuestDto> dtoList,
                             @Context UserRepository userRepository,
                             @Context MeetingRepository meetingRepository);

    @Named("findGuestById")
    default Guest findGuestById(Long id, @Context Gues) {
        return hostRepository.findGuestById(id);
    }
}
