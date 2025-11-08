package com.devhoss.model;


import io.quarkus.hibernate.orm.panache.Panache;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;

import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Table;

@Entity
@jakarta.persistence.Table(name = "Sbo_Category", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Category extends PanacheEntity {

    @NotNull
    public String name;
    @NotNull
    public String description;
}