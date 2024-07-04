package org.javaacademy.flat_rent.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.flat_rent.dto.AdvertisementDto;
import org.javaacademy.flat_rent.dto.AdvertisementDtoRq;
import org.javaacademy.flat_rent.service.AdvertisementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/advert")
@RequiredArgsConstructor
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    @PostMapping
    public ResponseEntity create(@RequestBody AdvertisementDtoRq body) {
        advertisementService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<AdvertisementDto>> findAll(@RequestParam String city,
                                                          @RequestParam Integer roomCount,
                                                          @RequestParam BigDecimal priceMin,
                                                          @RequestParam BigDecimal priceMax,
                                                          @RequestParam Integer portionSize,
                                                          @RequestParam Integer startElement) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(advertisementService.findAll(city, roomCount, priceMin, priceMax,
                        portionSize, startElement));
    }

    @GetMapping("/{id}")
    public ResponseEntity changeStatusToArchiveById(@PathVariable Long id) {
        advertisementService.changeStatusToArchiveById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }
}
