package com.example.yeoreumjava.major.mapper;

import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.MajorDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MajorMapper {
    MajorMapper INSTANCE = Mappers.getMapper(MajorMapper.class);

    @Named("E2D")
    @Mapping(target = "id",source = "id")
    @Mapping(target = "name",source = "name")
    public MajorDTO toDTO(Major major);
    @Named("D2E")

    @Mapping(target = "id",source = "id")
    @Mapping(target = "name",source = "name")
    public Major toEntity(MajorDTO majorDTO);

    @IterableMapping(qualifiedByName = "E2D")
    public List<MajorDTO> toDTOs(List<Major> majors);

    @IterableMapping(qualifiedByName = "D2E")
    public List<Major> toEntitys(List<MajorDTO> majorDTOs);
}
