package fhv.musicshop;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Album extends PanacheEntity {

    private String label;
    private UUID albumId;
    private String title;
    private LocalDate releaseDate;



    public Album() {
    }

    public Album(String title, LocalDate releaseDate, UUID albumId, String label) {
        this.label = label;
        this.albumId = albumId;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public String getLabel() {
        return label;
    }

    public UUID getAlbumId() {
        return albumId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }
}
