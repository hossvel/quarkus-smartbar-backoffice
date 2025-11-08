package com.devhoss.repository;

import com.devhoss.model.Article;
import com.devhoss.model.Category;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ArticleRepository  implements PanacheRepository<Article> {

    public List<Article> listByCategory(Category category) {
        return list("category", Sort.by("price", Sort.Direction.Descending), category);
    }

}
