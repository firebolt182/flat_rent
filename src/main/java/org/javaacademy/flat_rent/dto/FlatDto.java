package org.javaacademy.flat_rent.dto;

import lombok.Data;

@Data
public class FlatDto {
    private Long id;
    private String region;
    private String city;
    private String street;
    private String homeNumber;
    private Integer roomCount;
}
