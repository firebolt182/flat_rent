package org.javaacademy.flat_rent.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDtoRq {
    private BigDecimal oneNightPrice;
    private Long flatId;
    private String description;
}
