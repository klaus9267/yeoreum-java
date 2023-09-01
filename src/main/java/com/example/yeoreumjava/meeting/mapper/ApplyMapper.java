package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.domain.dto.ApplyResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ApplyMapper extends BaseMapper<ApplyRequest, ApplyResponse, Apply> {
    ApplyMapper instance = Mappers.getMapper(ApplyMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    ApplyResponse toDto(Apply entity);

    @Override
    @Named("D2E")
    @Mapping(target = "guestList", ignore = true)
    @Mapping(target = "meeting", ignore = true)
    Apply toEntity(ApplyRequest dto);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<ApplyResponse> toDtoList(List<Apply> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<Apply> toEntityList(List<ApplyRequest> dtoList);
}
