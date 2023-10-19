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
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = MajorService.class)
public interface UserMapper extends BaseMapper<UserRequest, UserResponse, User> {
    UserMapper instance = Mappers.getMapper(UserMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "majorId", expression = "java(entity.getMajor().getId())")
//    @Mapping(target = "authorities", ignore = true)
//    @Mapping(target = "hashedPassword", ignore = true)
    UserResponse toDto(User entity);

    @Override
    User toEntity(UserRequest dto);

    @Override
    List<UserResponse> toDtoList(List<User> entityList);

    @Override
    List<User> toEntityList(List<UserRequest> dtoList);
}
