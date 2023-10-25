package com.example.yeoreumjava.board.mapper;


import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.dto.BoardPagination;
import com.example.yeoreumjava.board.domain.dto.BoardRequest;
import com.example.yeoreumjava.board.domain.dto.BoardResponse;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.meeting.domain.Apply;
import com.example.yeoreumjava.meeting.domain.Host;
import com.example.yeoreumjava.meeting.domain.Meeting;
import com.example.yeoreumjava.meeting.domain.dto.ApplyResponse;
import com.example.yeoreumjava.meeting.domain.dto.HostResponse;
import com.example.yeoreumjava.user.UserService;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = {UserService.class})
public interface BoardMapper extends BaseMapper<BoardRequest, BoardResponse, Board> {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "writerName", expression = "java(entity.getWriter().getUsername())")
    @Mapping(target = "meetingId", expression = "java(entity.getMeeting().getId())")
    @Mapping(target = "hostList", source = "meeting", qualifiedByName = "setHostList")
    @Mapping(target = "applyList", source = "meeting", qualifiedByName = "setApplyList")
    BoardResponse toDto(Board entity);

    @Override
    @Named("E2DL")
    @IterableMapping(qualifiedByName = "E2D")
    List<BoardResponse> toDtoList(List<Board> entityList);


    @Mapping(target = "boardResponseList", source =" boardPage.content",qualifiedByName = "E2DL")
    @Mapping(target = "page",expression = "java(boardPage.getPageable().getPageNumber())")
    @Mapping(target = "totalPage",expression = "java(boardPage.getTotalPages())")
    @Mapping(target = "totalElements",expression = "java(boardPage.getTotalElements())")
    BoardPagination toPagination(Page<Board> boardPage);

    @Named("setHostList")
    default List<HostResponse> setHostList(Meeting meeting) {
        List<Host> hostList = meeting.getHostList();
        return hostList.stream().map(host -> HostResponse.builder()
                                                         .id(host.getId())
                                                         .meetingId(host.getMeeting().getId())
                                                         .username(host.getUser().getUsername())
                                                         .build())
                       .collect(Collectors.toList());
    }

    @Named("setApplyList")
    default List<ApplyResponse> setApplyList(Meeting meeting) {
        List<Apply> applyList = meeting.getApplyList();
        return applyList.stream().map(apply -> ApplyResponse.builder()
                                                            .title(apply.getTitle())
                                                            .content(apply.getContent())
                                                            .meetingId(apply.getMeeting().getId()).build())
                        .collect(Collectors.toList());
    }
}
