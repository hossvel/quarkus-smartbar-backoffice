package com.devhoss;

import com.devhoss.model.Category;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
class CategoriesResourceTest {

    @Test
    void getsListCategories() {

        final Category category = new Category();
        category.name = ("InjectMock");
        Mockito.when(Category.listAll()).thenReturn(List.of(category));

       final Response response = given()
                .when().get("/categories")
                .then()
               .statusCode(200)
                .extract().response();
       final JsonPath jsonPath = response.jsonPath();
       Assertions.assertEquals("InjectMock",jsonPath.getString("[0].name"));
    }


}