package com.devhoss.services;

import com.devhoss.model.Table;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

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

    @Override
    protected Class<Table> getEntityClass() {
        return Table.class;
    }
}
