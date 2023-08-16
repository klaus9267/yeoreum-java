package com.example.yeoreumjava.board.mapper;


import com.example.yeoreumjava.board.domain.Board;
import com.example.yeoreumjava.board.domain.BoardDTO;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoardMapper extends BaseMapper<BoardDTO,Board> {
    BoardMapper INSTANCE = Mappers.getMapper( BoardMapper.class );
//    @Named("E2D")
//    @Mapping(target = "id",source = "id")
//    @Mapping(target = "title",source = "title")
//    @Mapping(target = "content",source = "content")
//    @Mapping(target = "writer",source = "writer")
//    @Mapping(target = "meeting",source = "meeting")
//    public BoardDTO toDTO(Board user);
//
//    @Named("D2E")
//    @Mapping(target = "id",source = "id")
//    @Mapping(target = "title",source = "title")
//    @Mapping(target = "content",source = "content")
//    @Mapping(target = "writer",source = "writer")
//    @Mapping(target = "meeting",source = "meeting")
//    public Board toEntity(BoardDTO userDTO);
//
//    @IterableMapping(qualifiedByName = "E2D")
//    public List<BoardDTO> toDTOs(List<Board> users);
//
//    @IterableMapping(qualifiedByName = "D2E")
//    public List<Board> toEntitys(List<BoardDTO> userDTOs);
}
