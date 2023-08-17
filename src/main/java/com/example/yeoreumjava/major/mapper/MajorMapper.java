package com.example.yeoreumjava.major.mapper;

import com.example.yeoreumjava.board.mapper.BoardMapper;
import com.example.yeoreumjava.common.mapper.BaseMapper;
import com.example.yeoreumjava.major.MajorRepository;
import com.example.yeoreumjava.major.domain.Major;
import com.example.yeoreumjava.major.domain.dto.MajorDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        uses = MajorMapper.class)
public interface MajorMapper extends BaseMapper<MajorDto,Major> {
    MajorMapper INSTANCE = Mappers.getMapper(MajorMapper.class);

    @Named("findMajorById")
    default Major findMajorById(Long id,@Context MajorRepository majorRepository) {
        return majorRepository.findMajorById(id);
    }
}
