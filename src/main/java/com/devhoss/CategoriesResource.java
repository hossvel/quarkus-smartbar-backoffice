package com.devhoss;

import com.devhoss.api.CategoriesApi;
import com.devhoss.model.Category;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
@Produces(MediaType.APPLICATION_JSON)
public class CategoriesResource implements CategoriesApi {
    private final Category category = new Category().name("drinks");

    @Override
    public Response createCategory(Category category) {
        return Response.created(URI.create("todo")).build();
    }

    @Override
    public Response deleteCategoryById(String categoryId) {
        return Response.ok().build();
    }

    @Override
    public Response getCategories() {
        return Response.ok(List.of(category)).build();
    }

    @Override
    public Response getCategoryById(String categoryId) {
        return Response.ok(category).build();
    }

    @Override
    public Response updateCategoryById(String categoryId, Category category) {
        return Response.ok().build();
    }
}
