package org.javaacademy.flat_rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDtoRq {
    private LocalDate startBooking;
    private Integer daysCount;
    private String clientName;
    private String clientEmail;
    private Long advertisementId;
}
