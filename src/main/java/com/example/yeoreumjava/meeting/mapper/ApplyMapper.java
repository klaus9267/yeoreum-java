package com.example.yeoreumjava.meeting.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.Guest;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.ApplyPagination;
import com.example.yeoreumjava.meeting.domain.dto.ApplyRequest;
import com.example.yeoreumjava.meeting.domain.dto.ApplyResponse;
import com.example.yeoreumjava.meeting.domain.dto.GuestResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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
    @Named("E2DL")
    @IterableMapping(qualifiedByName = "E2D")
    List<ApplyResponse> toDtoList(List<Apply> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<Apply> toEntityList(List<ApplyRequest> dtoList);

    @Mapping(target = "applyResponseList", source =" applyPage.content",qualifiedByName = "E2DL")
    @Mapping(target = "page",expression = "java(applyPage.getPageable().getPageNumber())")
    @Mapping(target = "totalPage",expression = "java(applyPage.getTotalPages())")
    @Mapping(target = "totalElements",expression = "java(applyPage.getTotalElements())")
    ApplyPagination toPagination(Page<Apply> applyPage);

    @Named("setGuestList")
    default List<GuestResponse> setGuestList(Meeting meeting) {
        List<Guest> guestList = meeting.getApplyList().;
        return applyList.stream().map(apply -> ApplyResponse.builder()
                                                            .title(apply.getTitle())
                                                            .content(apply.getContent())
                                                            .meetingId(apply.getMeeting().getId()).build())
                        .collect(Collectors.toList());
    }
}
