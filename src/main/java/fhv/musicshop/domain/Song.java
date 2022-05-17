package fhv.musicshop.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity
public class Song extends PanacheEntity {

    private String genre;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Artist> artists;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Album> inAlbum;
    private String title;
    private LocalDate releaseDate;

    private BigDecimal price;
    private int stock;
    private MediumType mediumType;

    public Song() {
    }

    public Song(String title, LocalDate releaseDate, String genre, List<Artist> artists, Set<Album> inAlbum) {
        this.genre = genre;
        this.artists = artists;
        this.title = title;
        this.releaseDate = releaseDate;
        this.inAlbum = inAlbum;
        this.mediumType = MediumType.DIGITAL;
        this.stock = -1;
        this.price = BigDecimal.TEN;
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
        return title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
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
