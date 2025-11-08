package com.devhoss.resource;

import com.devhoss.api.ArticlesApi;
import com.devhoss.mapper.ArticleMapper;
import com.devhoss.model.ApiArticle;
import com.devhoss.model.Article;
import com.devhoss.model.Category;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class ArticlesResource  implements ArticlesApi {


    private final ArticleMapper mappingArticles;

    @Inject
    public ArticlesResource( ArticleMapper mappingArticles) {

        this.mappingArticles = mappingArticles;

    }

    @Override
    public Response createArticle(Long xCategoryId, ApiArticle apiArticle) {
        System.out.println("xCategoryId: " + xCategoryId);
        final Optional<Category> category = Category.findByIdOptional(xCategoryId);
        if(category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = new Article();
        mappingArticles.mapToArticle(apiArticle, article);
        article.category = category.get();
        article.persist();
        return Response.created(URI.create("/articles/" + article.id)).build();
    }

    @Override
    public Response deleteArticleById(Long articleId) {
        final Optional<Article> article = Article.findByIdOptional(articleId);
        if (article.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        article.get().delete();
        return Response.ok().build();
    }

    @Override
    public Response getArticleById(Long articleId) {
        final Optional<Article> article = Article.findByIdOptional(articleId);
        if (article.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(mappingArticles.mapToApiArticle(article.get())).build();
    }

    @Override
    public Response getArticles() {
        final List<Article> articles = Article.listAll();
        return Response.ok(articles.stream().map(mappingArticles::mapToApiArticle).toList())
                .build();
    }

    @Override
    public Response updateArticleById(Long articleId, ApiArticle apiArticle) {
        final Optional<Article> existingArticle = Article.findByIdOptional(articleId);
        if (existingArticle.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = existingArticle.get();
        mappingArticles.mapToArticle(apiArticle, article);

        return Response.ok().build();
    }
}
