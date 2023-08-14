package com.example.yeoreumjava.major.mapper;

import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.MajorDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MajorMapper {
    MajorMapper INSTANCE = Mappers.getMapper(MajorMapper.class);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "name",source = "name")
    public MajorDTO toDTO(Major major);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "name",source = "name")
    public Major toEntity(MajorDTO majorDTO);
}
