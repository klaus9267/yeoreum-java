package com.example.yeoreumjava.profile.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.profile.domain.Profile;
import com.example.yeoreumjava.profile.domain.dto.ProfileRequest;
import com.example.yeoreumjava.profile.domain.dto.ProfileResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = MajorService.class)
public interface ProfileMapper extends BaseMapper<ProfileRequest, ProfileResponse, Profile> {
    ProfileMapper instance = Mappers.getMapper(ProfileMapper.class);
    @Override
    @Named("E2D")
    @Mapping(target = "majorId", expression = "java(entity.getMajor().getId())")
    ProfileResponse toDto(Profile entity);

    @Named("D2E")
    @Mapping(target = "major", source = "majorId", qualifiedByName = "loadMajor")
    @Mapping(target = "boardList", ignore = true)
    Profile toEntity(ProfileRequest dto, @Context MajorService majorService);

    @IterableMapping(qualifiedByName = "D2E")
    List<Profile> toEntityList(List<ProfileRequest> dtoList, @Context MajorService majorService);
}
