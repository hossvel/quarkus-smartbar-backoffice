package com.devhoss;


import com.devhoss.model.ApiCategory;
import com.devhoss.services.CategoriesService;
import io.quarkus.test.Mock;

import java.util.List;

@Mock
public class MockCategoriesService extends CategoriesService {

    private final ApiCategory category = new ApiCategory().name("drinksMockService");
    public List<ApiCategory> getAll() {
        return List.of(category);
    }
}