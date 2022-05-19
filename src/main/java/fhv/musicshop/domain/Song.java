package fhv.musicshop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;


@Entity
public class Song extends PanacheEntityBase {

    private String genre;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Artist> artists;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Album> inAlbum;

    @EmbeddedId
    private SongId songId;

    private BigDecimal price;
    private int stock;
    private MediumType mediumType;

    public Song() {
    }

    public Song(String title, LocalDate releaseDate, String genre, List<Artist> artists, Set<Album> inAlbum) {
        this.genre = genre;
        this.artists = artists;
        this.inAlbum = inAlbum;
        this.mediumType = MediumType.DIGITAL;
        this.stock = -1;
        this.price = BigDecimal.TEN;
        this.songId = new SongId(title, releaseDate);
    }

    public String getGenre() {
        return genre;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public Set<Album> getInAlbum() {
        return inAlbum;
    }

    public String getTitle() {
        return songId.getTitle();
    }

    public LocalDate getReleaseDate() {
        return songId.getReleaseDate();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public MediumType getMediumType() {
        return mediumType;
    }
}
