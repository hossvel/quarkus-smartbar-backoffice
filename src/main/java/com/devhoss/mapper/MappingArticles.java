package com.devhoss.mapper;

import com.devhoss.model.ApiArticle;
import com.devhoss.model.Article;
import jakarta.enterprise.context.ApplicationScoped;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface MappingArticles {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "picture", target = "pictureBase64")
    void mapApiArticleToArticle(ApiArticle apiArticle, @MappingTarget Article article);

    @Mapping(source = "pictureBase64", target = "picture")
    ApiArticle mapArticleToApiArticle(Article article);
}
