package org.javaacademy.flat_rent.mapper;

import org.javaacademy.flat_rent.dto.FlatDto;
import org.javaacademy.flat_rent.dto.FlatDtoRq;
import org.javaacademy.flat_rent.entity.Flat;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlatMapper {

    Flat convertToEntity(FlatDtoRq flatDtoRq);

    FlatDto convertToDto(Flat flat);

    List<FlatDto> convertToDto(List<Flat> flatList);
}
