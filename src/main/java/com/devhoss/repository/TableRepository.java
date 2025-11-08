package com.devhoss.repository;

import com.devhoss.model.Table;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TableRepository  implements PanacheRepository<Table> {
}
