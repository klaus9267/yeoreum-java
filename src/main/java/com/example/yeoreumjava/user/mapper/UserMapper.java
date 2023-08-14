package com.example.yeoreumjava.user.mapper;

import com.example.yeoreumjava.user.domain.User;
import com.example.yeoreumjava.user.domain.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper{
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    @Mapping(target = "name",source = "name")
    @Mapping(target = "major",source = "major")
    public UserDTO toDTO(User user);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "name",source = "name")
    @Mapping(target = "major",source = "major")
    public User toEntity(UserDTO userDTO);
}
