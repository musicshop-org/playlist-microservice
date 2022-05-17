package fhv.musicshop;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Song extends PanacheEntity {

    private String genre;
    @ManyToMany
    private List<Artist> artists;
    @ManyToMany
    private final Set<Album> inAlbum = new HashSet<>();
    private String title;
    private LocalDate releaseDate;

    public Song() {
    }

    public Song(String title, LocalDate releaseDate, String genre, List<Artist> artists) {
        this.genre = genre;
        this.artists = artists;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", genre='" + genre + '\'' +
                ", artists=" + artists +
                ", inAlbum=" + inAlbum +
                '}';
    }
}
