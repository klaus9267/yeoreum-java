package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.MeetingService;
import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.domain.dto.ApplyResponse;
import com.example.yeoreumjava.user.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {MeetingService.class, UserService.class})
public interface ApplyMapper extends BaseMapper<ApplyRequest, ApplyResponse, Apply> {
    @Override
    ApplyResponse toDto(Apply entity);

    @Override
    Apply toEntity(ApplyRequest dto);

    @Override
    List<ApplyResponse> toDtoList(List<Apply> entityList);

    @Override
    List<Apply> toEntityList(List<ApplyRequest> dtoList);
}
