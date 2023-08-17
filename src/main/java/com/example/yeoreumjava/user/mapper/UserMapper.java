package com.example.yeoreumjava.user.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.MajorRepository;
import com.example.yeoreumjava.major.mapper.MajorMapper;
import com.example.yeoreumjava.user.repository.UserRepository;
import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.dto.UserDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = MajorMapper.class)
public interface UserMapper extends BaseMapper<UserDto, User> {
    UserMapper instance = Mappers.getMapper(UserMapper.class);

    @Override
    @Named("E2D")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "majorId", expression = "java(entity.getMajor().getId())")
    UserDto toDto(User entity);

    @Named("D2EWI")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "major", source = "majorId", qualifiedByName = "findMajorById")
    User toEntity(UserDto dto, @Context MajorRepository majorRepository);

    @Override
    @IterableMapping(qualifiedByName = "E2D")
    List<UserDto> toDtoList(List<User> entityList);

    @IterableMapping(qualifiedByName = "D2EWI")
    List<User> toEntityList(List<UserDto> dtoList, @Context MajorRepository majorRepository);

    @Named("findUserById")
    default User findUserById(Long id,@Context UserRepository userRepository) {
        return userRepository.findUserById(id);
    }
}
