package com.devhoss.model;


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
public class Category extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}