package org.javaacademy.flat_rent.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String region;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String homeNumber;

    @Column
    @Min(0)
    private Integer roomCount;
}
