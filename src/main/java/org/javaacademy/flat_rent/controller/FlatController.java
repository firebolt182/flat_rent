package org.javaacademy.flat_rent.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.flat_rent.dto.FlatDto;
import org.javaacademy.flat_rent.dto.FlatDtoRq;
import org.javaacademy.flat_rent.service.FlatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/flat")
@RequiredArgsConstructor
public class FlatController {
    private final FlatService flatservice;

    @PostMapping
    public ResponseEntity create(@RequestBody FlatDtoRq body) {
        flatservice.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<FlatDto>> findAllWithFilters(@RequestParam String city,
                                                 @RequestParam Integer roomCount,
                                                 @RequestParam Integer portionSize,
                                                 @RequestParam Integer startElement) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(flatservice.findAllWithFilters(city, roomCount, portionSize, startElement));

    }

    @GetMapping("/all")
    public ResponseEntity<List<FlatDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(flatservice.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlatDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(flatservice.findById(id));
    }
}
