package com.example.yeoreumjava.major.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.dto.MajorRequest;
import com.example.yeoreumjava.major.domain.dto.MajorResponse;
import com.example.yeoreumjava.major.repository.MajorRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MajorMapper extends BaseMapper<MajorRequest, MajorResponse, Major> {
    MajorMapper instance = Mappers.getMapper(MajorMapper.class);
}
