package com.devhoss;

import com.devhoss.api.ArticlesApi;
import com.devhoss.model.Article;
import jakarta.ws.rs.core.Response;

public class ArticlesResource implements ArticlesApi {
    @Override
    public Response createArticle(Article article) {
        return null;
    }

    @Override
    public Response deleteArticleById(String articleId) {
        return null;
    }

    @Override
    public Response getArticleById(String articleId) {
        return null;
    }

    @Override
    public Response getArticles() {
        return null;
    }

    @Override
    public Response updateArticleById(String articleId, Article article) {
        return null;
    }
}
