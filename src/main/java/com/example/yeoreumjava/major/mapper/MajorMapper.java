package com.example.yeoreumjava.major.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.MajorDTO;
import com.example.yeoreumjava.user.domain.UserDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MajorMapper extends BaseMapper<MajorDTO,Major> {
    MajorMapper INSTANCE = Mappers.getMapper(MajorMapper.class);

    @Named("major")
    default Major entityFromId(Long id) {
        return Major.builder()
                    .id(id)
                    .build();
    }
}
