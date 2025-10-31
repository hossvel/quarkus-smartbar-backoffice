package com.devhoss;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class CategoriesResourceTest {

    @Test
    void getsListCategories() {
       final Response response = given()
                .when().get("/categories")
                .then()
               .statusCode(200)
                .extract().response();
       final JsonPath jsonPath = response.jsonPath();
       Assertions.assertEquals("drinks",jsonPath.getString("[0].name"));
    }
}