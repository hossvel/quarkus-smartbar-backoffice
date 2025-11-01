package com.devhoss.services;

import com.devhoss.model.ApiTable;
import com.devhoss.model.Category;
import com.devhoss.model.Table;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class TablesService extends CrudService<Table> {

    public TablesService() {
        // Just for CDI requirements
        super(null);
    }

    @Inject
    public TablesService(EntityManager entityManager) {
        super(entityManager);
    }
}
