package org.javaacademy.flat_rent.mapper;

import org.javaacademy.flat_rent.dto.BookingDto;
import org.javaacademy.flat_rent.dto.BookingDtoRq;
import org.javaacademy.flat_rent.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mapping(target = "advertisementDto", source = "advertisement")
    BookingDto convertToDto(Booking booking);
    Booking convertToEntity(BookingDtoRq bookingDtoRq);
}
