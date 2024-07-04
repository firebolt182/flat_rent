package org.javaacademy.flat_rent;

import io.restassured.RestAssured;
import lombok.RequiredArgsConstructor;
import org.javaacademy.flat_rent.dto.FlatDtoRq;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@RequiredArgsConstructor
public class FlatControllerTest {

    private static final String BASE_URL = "http://localhost:8080";
    private static final String BASE_URL_POSTFIX = "/flat";
    @Test
    @DisplayName("Создание жилья")
    public void createFlatSuccess() {
        FlatDtoRq flatDtoRq = FlatDtoRq.builder()
                .region("Москва")
                .city("Москва")
                .street("Никольская")
                .homeNumber("32a")
                .roomCount(2)
                .build();
        RestAssured.given()
                .body(flatDtoRq)
                .log().all()
                .post(BASE_URL + BASE_URL_POSTFIX)
                .then()
                .log().all()
                .statusCode(201);
    }

}
