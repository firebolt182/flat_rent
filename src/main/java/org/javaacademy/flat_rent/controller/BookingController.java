package org.javaacademy.flat_rent.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.flat_rent.dto.BookingDto;
import org.javaacademy.flat_rent.dto.BookingDtoRq;
import org.javaacademy.flat_rent.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookingService.findById(id));
    }

    @PostMapping
    public ResponseEntity createBooking(@RequestBody BookingDtoRq body) {
        bookingService.createBooking(body);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<LinkedHashSet<LocalDate>> findFreeDates(@RequestParam Integer month,
                                                                  @RequestParam Integer year,
                                                                  @RequestParam Long advertId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookingService.findFreeDates(month, year, advertId));
    }
}
