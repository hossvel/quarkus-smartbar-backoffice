package com.devhoss;

import com.devhoss.model.Category;
import com.devhoss.services.CategoriesService;
import io.quarkus.test.Mock;

@Mock
public class MockCategoriesService extends CategoriesService {

    public Category get() {
        return new Category().name("drinks");
    }
}
