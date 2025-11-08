package com.devhoss.repository;

import com.devhoss.model.Category;
import com.devhoss.model.Table;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CategoryRepository  implements PanacheRepository<Category> {
}
