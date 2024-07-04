package org.javaacademy.flat_rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    private Long id;
    private LocalDate startBooking;
    private Integer daysCount;
    private String clientName;
    private String clientEmail;
    private AdvertisementDto advertisementDto;
    private BigDecimal allAdvertisementsPrice;
}
