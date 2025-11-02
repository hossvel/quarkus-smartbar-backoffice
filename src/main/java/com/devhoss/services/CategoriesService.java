package com.devhoss.services;

import com.devhoss.model.ApiCategory;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class CategoriesService {

    private final ApiCategory category = new ApiCategory().name("drinks");
    public List<ApiCategory> getAll() {
       return List.of(category);
    }
}
