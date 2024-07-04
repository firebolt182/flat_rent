package org.javaacademy.flat_rent.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.javaacademy.flat_rent.entity.Flat;
import org.javaacademy.flat_rent.entity.Status;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDto {
    private Long id;
    private BigDecimal oneNightPrice;
    private Status status;
    @ToString.Exclude
    private FlatDto flatDto;
    private String description;
}
