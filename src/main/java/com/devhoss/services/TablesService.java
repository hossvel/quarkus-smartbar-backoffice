package com.devhoss.services;

import com.devhoss.model.ApiTable;
import com.devhoss.model.Category;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TablesService {
    private final ApiTable category = new ApiTable().name("Berlin");

    public List<ApiTable> getAll() {
        return List.of(category);
    }

}
