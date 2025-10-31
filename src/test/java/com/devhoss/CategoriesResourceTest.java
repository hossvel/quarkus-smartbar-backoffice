package com.devhoss;

import com.devhoss.model.Category;
import com.devhoss.services.CategoriesService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


@QuarkusTest
class CategoriesResourceTest {

   // @InjectMock
   // CategoriesService categoriesServiceMock;


    @Test
    void getsListCategories() {

        //when(categoryService.getAll()).thenReturn(List.of(new Category("wine")));
       // when(categoriesServiceMock.get()).thenReturn(new Category().name("drinks"));

       final Response response = given()
                .when().get("/categories")
                .then()
               .statusCode(200)
                .extract().response();
       final JsonPath jsonPath = response.jsonPath();
       Assertions.assertEquals("drinks",jsonPath.getString("[0].name"));
    }


}