package com.example.yeoreumjava.common.mapper;

import java.util.List;

public interface BaseMapper<REQ, RES, E> {
    RES toDto(E entity);

    E toEntity(REQ dto);

    List<RES> toDtoList(List<E> entityList);

    List<E> toEntityList(List<REQ> dtoList);
}
