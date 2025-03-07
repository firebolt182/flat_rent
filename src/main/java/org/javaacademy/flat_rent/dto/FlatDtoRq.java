package org.javaacademy.flat_rent.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlatDtoRq {
    private String region;
    private String city;
    private String street;
    private String homeNumber;
    private Integer roomCount;
}
