package com.devhoss.resource;

import com.devhoss.model.ApiCategory;
import com.devhoss.services.CategoriesService;
import com.devhoss.api.CategoriesApi;

import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
@Produces(MediaType.APPLICATION_JSON)
public class CategoriesResource implements CategoriesApi {

    private final ApiCategory category = new ApiCategory().name("drinks!");
    private final CategoriesService categoriesService;

    @Inject
    public CategoriesResource(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @Override
    public Response createCategory(ApiCategory apiCategory) {
        return null;
    }

    @Override
    public Response deleteCategoryById(Long categoryId) {
        return null;
    }

    @Override
    public Response getCategories() {
        return Response.ok(categoriesService.getAll()).build();
    }

    @Override
    public Response getCategoryById(Long categoryId) {
        return null;
    }

    @Override
    public Response updateCategoryById(Long categoryId, ApiCategory apiCategory) {
        return null;
    }
}
