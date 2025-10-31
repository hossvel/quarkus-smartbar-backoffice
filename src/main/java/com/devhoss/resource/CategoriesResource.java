package com.devhoss.resource;

import com.devhoss.services.CategoriesService;
import com.devhoss.api.CategoriesApi;
import com.devhoss.model.Category;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
@Produces(MediaType.APPLICATION_JSON)
public class CategoriesResource implements CategoriesApi {
    private final Category category = new Category().name("drinks!");

    private final CategoriesService categoriesService;

    @Inject
    public CategoriesResource(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

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
        return Response.ok(categoriesService.getAll()).build();
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
