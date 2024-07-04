package org.javaacademy.flat_rent.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private LocalDate startBooking;

    @Column
    @Min(1)
    private Integer daysCount;

    @Column
    private String clientName;

    @Column
    private String clientEmail;


    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;

    @Column
    private BigDecimal allAdvertisementsPrice;

}
