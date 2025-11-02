package com.devhoss.resource;

import com.devhoss.api.ArticlesApi;
import com.devhoss.mapper.ArticleMapper;
import com.devhoss.mapper.MappingArticles;
import com.devhoss.mapper.MappingCategories;
import com.devhoss.model.ApiArticle;
import com.devhoss.model.Article;
import com.devhoss.model.Category;
import com.devhoss.services.ArticlesService;
import com.devhoss.services.CategoriesService;
import com.devhoss.services.TablesService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Produces(MediaType.APPLICATION_JSON)
public class ArticlesResource  implements ArticlesApi {

    private final ArticlesService articlesService;
    private final ArticleMapper mappingArticles;
    private final CategoriesService categoriesService;
    @Inject
    public ArticlesResource(ArticlesService articlesService, ArticleMapper mappingArticles, CategoriesService categoriesService) {
        this.articlesService = articlesService;
        this.mappingArticles = mappingArticles;
        this.categoriesService = categoriesService;
    }

    @Override
    public Response createArticle(Long xCategoryId, ApiArticle apiArticle) {
        System.out.println("xCategoryId: " + xCategoryId);
        final Optional<Category> category = categoriesService.getById(xCategoryId);
        if(category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = new Article();
        mappingArticles.mapToArticle(apiArticle, article);
        article.setCategory(category.get());
        final Article persitedArticle = articlesService.persit(article);
        return Response.created(URI.create("/articles/" + persitedArticle.getId())).build();
    }

    @Override
    public Response deleteArticleById(Long articleId) {
        final Optional<Article> article = articlesService.deleteById(articleId);
        if (article.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().build();
    }

    @Override
    public Response getArticleById(Long articleId) {
        final Optional<Article> article = articlesService.getById(articleId);
        if (article.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(mappingArticles.mapToApiArticle(article.get())).build();
    }

    @Override
    public Response getArticles() {
        final List<Article> articles = articlesService.listAll();
        return Response.ok(articles.stream().map(mappingArticles::mapToApiArticle).toList())
                .build();
    }

    @Override
    public Response updateArticleById(Long articleId, ApiArticle apiArticle) {
        final Optional<Article> existingArticle = articlesService.getById(articleId);
        if (existingArticle.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = existingArticle.get();
        mappingArticles.mapToArticle(apiArticle, article);
        articlesService.update(article);
        return Response.ok().build();
    }
}
