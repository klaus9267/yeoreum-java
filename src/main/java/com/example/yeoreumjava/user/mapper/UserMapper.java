package com.example.yeoreumjava.user.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.MajorRepository;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDTO, User> {
    UserMapper instance = Mappers.getMapper(UserMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "majorId", expression = "java(entity.getMajor().getId())")
    UserDTO toDto(User entity);

    @Named("D2EWI")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "major", source = "majorId", qualifiedByName = "findMajorById")
    User toEntity(UserDTO dto,@Context MajorRepository majorRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<UserDTO> toDtoList(List<User> entityList);

    @IterableMapping(qualifiedByName = "D2EWI")
    List<User> toEntityList(List<UserDTO> dtoList, @Context MajorRepository majorRepository);

    @Named("findMajorById")
    default Major findMajorById(Long id,@Context MajorRepository majorRepository) {
        return majorRepository.findMajorById(id);
    }
}
