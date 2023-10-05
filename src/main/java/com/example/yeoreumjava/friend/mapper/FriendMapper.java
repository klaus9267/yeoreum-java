package com.example.yeoreumjava.friend.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.friend.domain.Friend;
import com.example.yeoreumjava.friend.domain.dto.FriendRequest;
import com.example.yeoreumjava.friend.domain.dto.FriendResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FriendMapper extends BaseMapper<FriendRequest, FriendResponse, Friend> {
    FriendMapper instance = Mappers.getMapper(FriendMapper.class);

    @Override
    FriendResponse toDto(Friend entity);

    @Override
    Friend toEntity(FriendRequest dto);

    @Override
    List<FriendResponse> toDtoList(List<Friend> entityList);

    @Override
    List<Friend> toEntityList(List<FriendRequest> dtoList);
}
