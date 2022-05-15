package fhv.musicshop;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Playlist extends PanacheEntity {

    public String col1;
    public String col2;

    @Override
    public String toString() {
        return "Playlist{" +
                "col1='" + col1 + '\'' +
                ", col2='" + col2 + '\'' +
                '}';
    }
}
