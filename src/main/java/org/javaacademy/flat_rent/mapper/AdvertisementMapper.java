package org.javaacademy.flat_rent.mapper;

import org.javaacademy.flat_rent.dto.AdvertisementDto;
import org.javaacademy.flat_rent.dto.AdvertisementDtoRq;
import org.javaacademy.flat_rent.entity.Advertisement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AdvertisementMapper {
    Advertisement convertToEntity(AdvertisementDtoRq advertisementDtoRq);

    @Mapping(target = "flatDto", source = "flat")
    AdvertisementDto convertToDto(Advertisement advertisement);

}
