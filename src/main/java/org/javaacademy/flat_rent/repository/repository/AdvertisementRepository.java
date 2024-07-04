package org.javaacademy.flat_rent.repository.repository;

import org.javaacademy.flat_rent.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findAllByFlat_CityAndFlat_RoomCount(String city, Integer roomCount);
}
