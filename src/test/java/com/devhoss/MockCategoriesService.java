package com.devhoss;


import com.devhoss.model.Category;
import com.devhoss.services.CategoriesService;
import io.quarkus.test.Mock;

import java.util.List;

@Mock
public class MockCategoriesService extends CategoriesService {

    private final Category category = new Category().name("drinksMockService");
    public List<Category> getAll() {
        return List.of(category);
    }
}