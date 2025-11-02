package com.devhoss.resource;

import com.devhoss.mapper.MappingCategories;
import com.devhoss.mapper.MappingTables;
import com.devhoss.model.ApiCategory;
import com.devhoss.model.Category;
import com.devhoss.services.CategoriesService;
import com.devhoss.api.CategoriesApi;

import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Produces(MediaType.APPLICATION_JSON)
public class CategoriesResource implements CategoriesApi {

    private final CategoriesService categoriesService;
    private final MappingCategories mappingCategories;

    @Inject
    public CategoriesResource(CategoriesService categoriesService, MappingCategories mappingCategories) {
        this.categoriesService = categoriesService;
        this.mappingCategories = mappingCategories;
    }

    @Override
    public Response createCategory(ApiCategory apiCategory) {
        final Category category = new Category();
        mappingCategories.mapApiCategoryToCategory(apiCategory, category);
        final Category persitedCategory = categoriesService.persit(category);
        return Response.created(URI.create("/categories/" + persitedCategory.getId())).build();
    }

    @Override
    public Response deleteCategoryById(Long categoryId) {
        final Optional<Category> category = categoriesService.deleteById(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().build();
    }

    @Override
    public Response getCategories() {
        final List<Category> categories = categoriesService.listAll();
        return Response.ok(categories.stream().map(mappingCategories::mapCategoryToApiCategory).toList())
                .build();
    }

    @Override
    public Response getCategoryById(Long categoryId) {
        final Optional<Category> category = categoriesService.getById(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(mappingCategories.mapCategoryToApiCategory(category.get())).build();
    }

    @Override
    public Response updateCategoryById(Long categoryId, ApiCategory apiCategory) {
        final Optional<Category> existingCategory = categoriesService.getById(categoryId);
        if (existingCategory.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Category category = existingCategory.get();
        mappingCategories.mapApiCategoryToCategory(apiCategory, category);
        categoriesService.update(category);
        return Response.ok().build();
    }
}
