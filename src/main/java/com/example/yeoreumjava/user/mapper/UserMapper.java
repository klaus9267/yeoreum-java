package com.example.yeoreumjava.user.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserRequest;
import com.example.yeoreumjava.user.domain.dto.UserResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserRequest, UserResponse, User> {
    UserMapper instance = Mappers.getMapper(UserMapper.class);
}
