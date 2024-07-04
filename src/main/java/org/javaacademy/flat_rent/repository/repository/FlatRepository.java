package org.javaacademy.flat_rent.repository.repository;

import org.javaacademy.flat_rent.dto.FlatDto;
import org.javaacademy.flat_rent.dto.FlatDtoRq;
import org.javaacademy.flat_rent.entity.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlatRepository extends JpaRepository<Flat, Long> {
        List<Flat> findAllByCityAndRoomCount(String city, Integer roomCount);

}
