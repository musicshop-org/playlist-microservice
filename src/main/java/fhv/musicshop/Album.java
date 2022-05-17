package fhv.musicshop;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Entity
public class Album extends PanacheEntity {

    private String label;
    private UUID albumId;
    @ManyToMany
    private Set<Song> songs = new HashSet<>();
    private String title;
    private LocalDate releaseDate;



    public Album() {
    }

    public Album(String title, LocalDate releaseDate, UUID albumId, String label, Set<Song> songs) {
        this.label = label;
        this.albumId = albumId;
        this.songs = songs;
        this.title = title;
        this.releaseDate = releaseDate;
    }

}
