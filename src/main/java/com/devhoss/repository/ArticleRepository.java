package com.devhoss.repository;

import com.devhoss.model.Article;
import com.devhoss.model.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ArticleRepository  implements PanacheRepository<Article> {
}
