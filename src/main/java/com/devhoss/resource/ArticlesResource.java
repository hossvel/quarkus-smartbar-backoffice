package com.devhoss.resource;

import com.devhoss.api.ArticlesApi;
import com.devhoss.model.ApiArticle;
import com.devhoss.services.TablesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

public class ArticlesResource   implements ArticlesApi {

    @Override
    public Response createArticle(Long xCategoryId, ApiArticle apiArticle) {
        return null;
    }

    @Override
    public Response deleteArticleById(Long articleId) {
        return null;
    }

    @Override
    public Response getArticleById(Long articleId) {
        return null;
    }

    @Override
    public Response getArticles() {
        return null;
    }

    @Override
    public Response updateArticleById(Long articleId, ApiArticle apiArticle) {
        return null;
    }
}
