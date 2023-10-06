package com.example.yeoreumjava.profile.mapper;

import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.MajorService;
import com.example.yeoreumjava.profile.domain.Profile;
import com.example.yeoreumjava.profile.domain.dto.ProfileRequest;
import com.example.yeoreumjava.profile.domain.dto.ProfileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        uses = MajorService.class)
public interface ProfileMapper extends BaseMapper<ProfileRequest, ProfileResponse, Profile> {
    ProfileMapper instance = Mappers.getMapper(ProfileMapper.class);
}
