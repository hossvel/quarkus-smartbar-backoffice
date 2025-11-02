package com.devhoss.services;

import com.devhoss.model.Article;
import com.devhoss.model.Table;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@ApplicationScoped
public class ArticlesService extends CrudService<Article> {

    public ArticlesService() {
        // Just for CDI requirements
        super(null);
    }

    @Inject
    public ArticlesService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }
}