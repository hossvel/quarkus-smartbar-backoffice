package com.devhoss;

import com.devhoss.model.Category;
import com.devhoss.services.CategoriesService;
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

  // @InjectMock
  // CategoriesService categoriesServiceMock;

    @Test
    void getsListCategories() {

       // Mockito.when(categoriesServiceMock.getAll()).thenReturn(List.of(new Category().name("Mock")));

       final Response response = given()
                .when().get("/categories")
                .then()
               .statusCode(200)
                .extract().response();
       final JsonPath jsonPath = response.jsonPath();
       Assertions.assertEquals("drinksMockService",jsonPath.getString("[0].name"));
    }


}