package com.devhoss.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(
        name = "Sbo_Article",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name", "category_id"})
        }
)

public class Article extends PanacheEntity {

    @NotNull
    public String name;

    @NotNull
    @Positive
    public BigDecimal price;

    @NotNull
    public String description;

    @NotNull
    public String pictureBase64;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    public Category category;

}
