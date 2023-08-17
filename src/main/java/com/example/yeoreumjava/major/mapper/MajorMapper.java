package com.example.yeoreumjava.major.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.MajorDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MajorMapper extends BaseMapper<MajorDto, Major> {
    MajorMapper INSTANCE = Mappers.getMapper(MajorMapper.class);
}
