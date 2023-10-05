package com.example.yeoreumjava.user.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.domain.dto.UserResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = MajorService.class)
public interface UserMapper extends BaseMapper<UserRequest, UserResponse, User> {
    UserMapper instance = Mappers.getMapper(UserMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "majorId", expression = "java(entity.getMajor().getId())")
    UserResponse toDto(User entity);

    @Named("D2E")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "major", source = "majorId", qualifiedByName = "loadMajor")
    @Mapping(target = "boardList", ignore = true)
    User toEntity(UserRequest dto, @Context MajorService majorService);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<UserResponse> toDtoList(List<User> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<User> toEntityList(List<UserRequest> dtoList, @Context MajorService majorService);
}
