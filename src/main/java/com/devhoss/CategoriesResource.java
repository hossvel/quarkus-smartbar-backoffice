package com.devhoss;

import com.devhoss.api.CategoriesApi;
import com.devhoss.model.Category;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
@Produces(MediaType.APPLICATION_JSON)
public class CategoriesResource implements CategoriesApi {

    @Override
    public Response createCategory(Category category) {
        return null;
    }

    @Override
    public Response deleteCategoryById(String categoryId) {
        return null;
    }

    @Override
    public Response getCategories() {
        return Response.ok(List.of(new Category().name("drink"))).build();
    }

    @Override
    public Response getCategoryById(String categoryId) {
        return null;
    }

    @Override
    public Response updateCategoryById(String categoryId, Category category) {
        return null;
    }
}
