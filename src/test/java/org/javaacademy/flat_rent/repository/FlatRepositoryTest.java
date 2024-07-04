package org.javaacademy.flat_rent.repository;

import org.javaacademy.flat_rent.entity.Flat;
import org.javaacademy.flat_rent.repository.repository.FlatRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FlatRepositoryTest {
    @Autowired
    private FlatRepository flatRepository;

    @Test
    public void createFlat() {
        Flat createdFlat = Flat.builder()
                .region("Moscow")
                .city("Moscow")
                .street("Nikolskaya")
                .homeNumber("32a")
                .roomCount(2)
                .build();
        flatRepository.save(createdFlat);
        Flat flat = flatRepository.findAll().stream()
                .filter(f -> "Moscow".equals(f.getCity()))
                .findFirst()
                .orElseThrow();
        Assertions.assertEquals("Moscow", flat.getCity());
        Assertions.assertEquals("Nikolskaya", flat.getStreet());
        Assertions.assertEquals("32a", flat.getHomeNumber());
        Assertions.assertEquals(2, flat.getRoomCount());
    }
}
