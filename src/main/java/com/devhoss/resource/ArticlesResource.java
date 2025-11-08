package com.devhoss.resource;

import com.devhoss.api.ArticlesApi;
import com.devhoss.mapper.ArticleMapper;
import com.devhoss.model.ApiArticle;
import com.devhoss.model.Article;
import com.devhoss.model.Category;
import com.devhoss.repository.ArticleRepository;
import com.devhoss.repository.CategoryRepository;

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
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    @Inject
    public ArticlesResource( ArticleMapper mappingArticles,  ArticleRepository articleRepository, CategoryRepository categoryRepository) {

        this.mappingArticles = mappingArticles;
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Response createArticle(Long xCategoryId, ApiArticle apiArticle) {
        System.out.println("xCategoryId: " + xCategoryId);
        final Optional<Category> category = categoryRepository.findByIdOptional(xCategoryId);
        if(category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = new Article();
        mappingArticles.mapToArticle(apiArticle, article);
        article.setCategory(category.get());
        articleRepository.persist(article);
        return Response.created(URI.create("/articles/" + article.getId())).build();
    }

    @Override
    public Response deleteArticleById(Long articleId) {
        final Optional<Article> article = articleRepository.findByIdOptional(articleId);
        if (article.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        articleRepository.delete(article.get());
        return Response.ok().build();
    }

    @Override
    public Response getArticleById(Long articleId) {
        final Optional<Article> article = articleRepository.findByIdOptional(articleId);
        if (article.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(mappingArticles.mapToApiArticle(article.get())).build();
    }

    @Override
    public Response getArticles() {
        final List<Article> articles = articleRepository.listAll();
        return Response.ok(articles.stream().map(mappingArticles::mapToApiArticle).toList())
                .build();
    }

    @Override
    public Response updateArticleById(Long articleId, ApiArticle apiArticle) {
        final Optional<Article> existingArticle = articleRepository.findByIdOptional(articleId);
        if (existingArticle.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = existingArticle.get();
        mappingArticles.mapToArticle(apiArticle, article);

        return Response.ok().build();
    }
}
