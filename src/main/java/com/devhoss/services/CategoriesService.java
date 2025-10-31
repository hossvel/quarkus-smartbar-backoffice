package com.devhoss.services;

import com.devhoss.model.Category;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class CategoriesService {

    private final Category category = new Category().name("drinks");
    public List<Category> getAll() {
       return List.of(category);
    }
}
