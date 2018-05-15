package com.capgemini.airport1.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Airport {
    private long id;
    private String name;

    public Airport() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
