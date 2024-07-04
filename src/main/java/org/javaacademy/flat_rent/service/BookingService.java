package org.javaacademy.flat_rent.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.flat_rent.dto.BookingDto;
import org.javaacademy.flat_rent.dto.BookingDtoRq;
import org.javaacademy.flat_rent.entity.Advertisement;
import org.javaacademy.flat_rent.entity.Booking;
import org.javaacademy.flat_rent.mapper.BookingMapper;
import org.javaacademy.flat_rent.repository.repository.AdvertisementRepository;
import org.javaacademy.flat_rent.repository.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final AdvertisementRepository advertisementRepository;

    @Transactional(readOnly = true)
    public BookingDto findById(Long id) {
        return bookingMapper.convertToDto(bookingRepository.findById(id).orElseThrow());
    }

    @Transactional(readOnly = true)
    public LinkedHashSet<LocalDate> findFreeDates(int month, int year, Long advertId) {
        List<BookingDto> bookings = bookingRepository.findAllByAdvertisement_Id(advertId).stream()
                .map(bookingMapper::convertToDto)
                .toList();
        LocalDate start = LocalDate.of(year, month, 1);

        List<LocalDate> list = start.datesUntil(start.plusMonths(1)).toList();
        LinkedHashSet<LocalDate> result = new LinkedHashSet<>();
        for (LocalDate date : list) {
            iterateBookings(date, result, bookings);
        }
        return result;
    }

    @Transactional
    public void createBooking(BookingDtoRq bookingDtoRq) {
        Booking booking = bookingMapper.convertToEntity(bookingDtoRq);
        Advertisement advertisement =
                advertisementRepository.findById(bookingDtoRq.getAdvertisementId()).orElseThrow();
        booking.setAdvertisement(advertisement);
        booking.setAllAdvertisementsPrice(advertisement.getOneNightPrice()
                .multiply(BigDecimal.valueOf(booking.getDaysCount())));
        List<LocalDate> wishDates = booking.getStartBooking()
                .datesUntil(booking.getStartBooking()
                        .plusDays(booking.getDaysCount() - 1)).toList();
        LinkedHashSet<LocalDate> freeDates =
                findFreeDates(booking.getStartBooking().getMonth().getValue(),
                              booking.getStartBooking().getYear(),
                              booking.getAdvertisement().getId());
        for (LocalDate date : wishDates) {
            if (freeDates.contains(date)) {
                throw new RuntimeException("Желаемая дата занята");
            }
        }
        bookingRepository.save(booking);
    }

    private void iterateBookings(LocalDate date,
                                 LinkedHashSet<LocalDate> result,
                                 List<BookingDto> bookings) {
        for (BookingDto booking : bookings) {
            Integer realDays = booking.getDaysCount() - 1;
            if (date.isBefore(booking.getStartBooking())
                    || date.isAfter(booking.getStartBooking().plusDays(realDays))) {
                result.add(date);
            }
        }
    }
}
