package com.example.yeoreumjava.common.mapper;

import com.example.yeoreumjava.major.MajorRepository;
import org.mapstruct.Context;

import java.util.List;

public interface BaseMapper<D,E> {
    D toDto(E entity);
    E toEntity(D dto);

    List<D> toDtoList(List<E> entityList);
    List<E> toEntityList(List<D> dtoList);
}
