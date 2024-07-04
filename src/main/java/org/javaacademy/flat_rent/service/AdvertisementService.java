package org.javaacademy.flat_rent.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.flat_rent.dto.AdvertisementDto;
import org.javaacademy.flat_rent.dto.AdvertisementDtoRq;
import org.javaacademy.flat_rent.entity.Advertisement;
import org.javaacademy.flat_rent.entity.Flat;
import org.javaacademy.flat_rent.entity.Status;
import org.javaacademy.flat_rent.mapper.AdvertisementMapper;
import org.javaacademy.flat_rent.repository.repository.AdvertisementRepository;
import org.javaacademy.flat_rent.repository.repository.FlatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvertisementService {
    private final AdvertisementRepository advertisementRepository;
    private final FlatRepository flatRepository;
    private final AdvertisementMapper advertisementMapper;

    @Transactional
    public void create(AdvertisementDtoRq body) {
        Advertisement advertisement = advertisementMapper.convertToEntity(body);
        advertisement.setStatus(Status.ACTIVE);
        Flat flat = flatRepository.findById(body.getFlatId()).orElseThrow();
        advertisement.setFlat(flat);
        advertisementRepository.save(advertisement);
    }

    @Transactional(readOnly = true)
    public List<AdvertisementDto> findAll(String city,
                                          Integer roomCount,
                                          BigDecimal priceMin,
                                          BigDecimal priceMax,
                                          Integer portionSize,
                                          Integer startElement) {
        List<Advertisement> advertisementList =
                advertisementRepository.findAllByFlat_CityAndFlat_RoomCount(city, roomCount);
        return advertisementList.stream()
                .skip(startElement - 1)
                .limit(portionSize)
                .filter(advertisement -> advertisement.getStatus().equals(Status.ACTIVE))
                .filter(advertisement -> advertisement.getOneNightPrice().compareTo(priceMin) >= 0)
                .filter(advertisement -> advertisement.getOneNightPrice().compareTo(priceMax) <= 0)
                .map(advertisementMapper::convertToDto).toList();
    }

    public void changeStatusToArchiveById(Long id) {
        Advertisement advertisement = advertisementRepository.findById(id).orElseThrow();
        advertisement.setStatus(Status.ARCHIVE);
    }
}
