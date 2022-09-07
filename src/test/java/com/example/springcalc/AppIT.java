package com.example.springcalc;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AppIT {

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
    }

    @Test
    public void checkStartPage() {
        when().get().then()
                .statusCode(200)
                .body(containsString("<h1>Welcome! Type /users to view users</h1>"));
    }

    @Test
    public void validates_getPerson() {
        when().get("/users").then()
                .statusCode(200)
                .body("[0].id", Matchers.equalTo(1))
                .body("[1].name", Matchers.equalTo("Hugo"))
                .body("[2].name", Matchers.equalTo("Pernilla"));
    }
}
