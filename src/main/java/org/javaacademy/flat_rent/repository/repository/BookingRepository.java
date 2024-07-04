package org.javaacademy.flat_rent.repository.repository;

import org.javaacademy.flat_rent.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByAdvertisement_Id(Long id);
}
