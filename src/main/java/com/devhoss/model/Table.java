package com.devhoss.model;



import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;

@Entity
@jakarta.persistence.Table(name = "Sbo_Table", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Table extends PanacheEntity {

    public String name;
    public Integer seatCount;
    public Boolean active;
}