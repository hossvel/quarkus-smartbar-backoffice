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
    public void createCategory(Category category) {

    }

    @Override
    public void deleteCategoryById(String categoryId) {

    }

    @Override
    public List<Category> getCategories() {
        return List.of(new Category().name("drink!"));
    }

    @Override
    public Category getCategoryById(String categoryId) {
        return null;
    }

    @Override
    public void updateCategoryById(String categoryId, Category category) {

    }
}
