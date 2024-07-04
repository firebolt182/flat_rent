package org.javaacademy.flat_rent.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.flat_rent.dto.FlatDto;
import org.javaacademy.flat_rent.dto.FlatDtoRq;
import org.javaacademy.flat_rent.entity.Flat;
import org.javaacademy.flat_rent.mapper.FlatMapper;
import org.javaacademy.flat_rent.repository.repository.FlatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlatService {
    private final FlatRepository flatRepository;
    private final FlatMapper flatMapper;

    @Transactional
    public void create(FlatDtoRq flatDtoRq) {
        Flat flat = flatMapper.convertToEntity(flatDtoRq);
        flatRepository.save(flat);
    }

    @Transactional(readOnly = true)
    public List<FlatDto> findAllWithFilters(String city,
                                 Integer roomCount,
                                 Integer portionSize,
                                 Integer startElement) {
        List<Flat> flatList = flatRepository.findAllByCityAndRoomCount(city, roomCount);
        return flatList.stream()
                .skip(startElement)
                .limit(portionSize)
                .map(flatMapper::convertToDto).toList();

    }

    @Transactional(readOnly = true)
    public FlatDto findById(Long id) {
        return flatMapper.convertToDto(flatRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public List<FlatDto> findAll() {
        return flatMapper.convertToDto(flatRepository.findAll());
    }
}
