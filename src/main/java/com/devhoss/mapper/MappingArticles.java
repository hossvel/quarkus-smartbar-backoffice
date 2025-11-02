package com.devhoss.mapper;

import com.devhoss.model.ApiArticle;
import com.devhoss.model.Article;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MappingArticles {

    public void mapApiArticleToArticle(ApiArticle apiArticle, Article article) {
        article.setName(apiArticle.getName());
        article.setDescription(apiArticle.getDescription());
        article.setPrice(apiArticle.getPrice());
        article.setPictureBase64(apiArticle.getPicture());
    }

    public ApiArticle mapArticleToApiArticle(Article article) {
        final ApiArticle apiArticle = new ApiArticle();
        apiArticle.setDescription(article.getDescription());
        apiArticle.setName(article.getName());
        apiArticle.setPicture(article.getPictureBase64());
        apiArticle.setPrice(article.getPrice());
        apiArticle.setId(article.getId());
        return apiArticle;
    }
}
