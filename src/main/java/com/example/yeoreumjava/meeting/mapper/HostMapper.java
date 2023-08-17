package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.dto.HostDto;
import com.example.yeoreumjava.meeting.repository.HostRepository;
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
public interface HostMapper extends BaseMapper<HostDto, Host> {
    HostMapper instance = Mappers.getMapper(HostMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", expression = "java(entity.getUser().getId())")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    HostDto toDto(Host entity);

    @Named("D2EWI")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "user", source = "userId", qualifiedByName = "findUserById")
    @Mapping(target = "meeting", source = "meetingId", qualifiedByName = "findMeetingById")
    Host toEntity(HostDto dto,
                  @Context UserRepository userRepository,
                  @Context MeetingRepository meetingRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<HostDto> toDtoList(List<Host> entityList);

    @IterableMapping(qualifiedByName = "D2EWI")
    List<Host> toEntityList(List<HostDto> dtoList,
                            @Context UserRepository userRepository,
                            @Context MeetingRepository meetingRepository);

    @Named("findHostById")
    default Host findHostById(Long id, @Context HostRepository hostRepository) {
        return hostRepository.findHostById(id);
    }
}
