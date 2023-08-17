package com.example.yeoreumjava.user.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.repository.MajorRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<UserDto, User> {
    UserMapper instance = Mappers.getMapper(UserMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "majorId", expression = "java(entity.getMajor().getId())")
    UserDto toDto(User entity);

    @Named("D2E")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "major", source = "majorId", qualifiedByName = "findMajorById")
    User toEntity(UserDto dto, @Context MajorRepository majorRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<UserDto> toDtoList(List<User> entityList);

    @IterableMapping(qualifiedByName = "D2E")
    List<User> toEntityList(List<UserDto> dtoList, @Context MajorRepository majorRepository);

    @Named("findMajorById")
    default Major findMajorById(Long id, @Context MajorRepository majorRepository) {
        return majorRepository.findMajorById(id);
    }
}
