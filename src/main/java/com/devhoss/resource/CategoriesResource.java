package com.devhoss.resource;

import com.devhoss.mapper.MappingCategories;
import com.devhoss.model.ApiCategory;
import com.devhoss.model.Category;
import com.devhoss.api.CategoriesApi;

import com.devhoss.model.Table;
import com.devhoss.repository.CategoryRepository;
import com.devhoss.repository.TableRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class CategoriesResource implements CategoriesApi {


    private final MappingCategories mappingCategories;
    private final CategoryRepository categoryRepository;
    @Inject
    public CategoriesResource( MappingCategories mappingCategories, CategoryRepository categoryRepository) {

        this.mappingCategories = mappingCategories;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Response createCategory(ApiCategory apiCategory) {
        final Category category = new Category();
        mappingCategories.mapApiCategoryToCategory(apiCategory, category);
        categoryRepository.persist(category);
        return Response.created(URI.create("/categories/" + category.getId())).build();
    }

    @Override
    public Response deleteCategoryById(Long categoryId) {
        final Optional<Category> category = categoryRepository.findByIdOptional(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        categoryRepository.delete(category.get());
        return Response.ok().build();
    }

    @Override
    public Response getCategories() {
        final List<Category> categories = categoryRepository.listAll();
        return Response.ok(categories.stream().map(mappingCategories::mapCategoryToApiCategory).toList())
                .build();
    }

    @Override
    public Response getCategoryById(Long categoryId) {
        final Optional<Category> category = categoryRepository.findByIdOptional(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(mappingCategories.mapCategoryToApiCategory(category.get())).build();
    }

    @Override
    public Response updateCategoryById(Long categoryId, ApiCategory apiCategory) {
        final Optional<Category> existingCategory = categoryRepository.findByIdOptional(categoryId);
        if (existingCategory.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Category category = existingCategory.get();
        mappingCategories.mapApiCategoryToCategory(apiCategory, category);

        return Response.ok().build();
    }
}
