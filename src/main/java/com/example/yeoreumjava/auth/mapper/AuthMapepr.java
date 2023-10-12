package com.example.yeoreumjava.auth.mapper;

import com.example.yeoreumjava.auth.AuthController;
import com.example.yeoreumjava.auth.domain.Authentication;
import com.example.yeoreumjava.auth.domain.dto.AuthRequest;
import com.example.yeoreumjava.auth.domain.dto.AuthResponse;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.mapper.MajorMapper;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthMapepr extends BaseMapper<AuthRequest, AuthResponse, Authentication> {
    AuthMapepr instance = Mappers.getMapper(AuthMapepr.class);
}
