package fhv.musicshop.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Artist extends PanacheEntity {

    private String name;

    protected Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
