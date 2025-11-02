package com.devhoss.services;

import com.devhoss.model.ApiCategory;
import com.devhoss.model.Category;
import com.devhoss.model.Table;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class CategoriesService  extends CrudService<Category> {

    public CategoriesService() {
        // Just for CDI requirements
        super(null);
    }

    @Inject
    public CategoriesService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
