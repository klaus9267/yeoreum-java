package com.example.yeoreumjava.user.mapper;

import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper{
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    @Named("E2D")
    @Mapping(target = "id",source = "id")
    @Mapping(target = "name",source = "name")
    @Mapping(target = "major",source = "major")
    public UserDTO toDTO(User user);

    @Named("D2E")
    @Mapping(target = "id",source = "id")
    @Mapping(target = "name",source = "name")
    @Mapping(target = "major",source = "major")
    public User toEntity(UserDTO userDTO);

    @IterableMapping(qualifiedByName = "E2D")
    public List<UserDTO> toDTOs(List<User> users);

    @IterableMapping(qualifiedByName = "D2E")
    public List<User> toEntitys(List<UserDTO> userDTOs);
}
