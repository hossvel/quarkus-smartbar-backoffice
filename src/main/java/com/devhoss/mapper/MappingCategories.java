package com.devhoss.mapper;

import com.devhoss.model.ApiCategory;
import com.devhoss.model.Category;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MappingCategories {
    public void mapApiCategoryToCategory(ApiCategory apiCategory, Category category) {
        category.setName(apiCategory.getName());
        category.setDescription(apiCategory.getDescription());
    }

    public ApiCategory mapCategoryToApiCategory(Category category) {
        final ApiCategory apiCategory = new ApiCategory();
        apiCategory.setDescription(category.getDescription());
        apiCategory.setName(category.getName());
        apiCategory.setId(category.getId());
        return apiCategory;
    }
}
