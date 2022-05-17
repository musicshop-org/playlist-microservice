package fhv.musicshop;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import org.jboss.resteasy.reactive.RestStreamElementType;

import javax.persistence.Entity;
import java.io.Serializable;
import java.lang.annotation.Retention;

@Getter
@Entity
public class Artist extends PanacheEntity {

    private String name;

    protected Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

}
