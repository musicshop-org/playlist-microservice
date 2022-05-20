package fhv.musicshop.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class Album extends PanacheEntityBase {

    private String title;
    private String imageUrl;
    private BigDecimal price;
    private int stock;
    @Enumerated(EnumType.STRING)
    private MediumType mediumType;
    private String releaseDate;
    @Id
    private UUID albumId;
    private String label;
    private int quantityToAddToCart;



    public Album() {
    }

    public Album(String title, String releaseDate, UUID albumId, String label) {
        this.label = label;
        this.albumId = albumId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.mediumType = MediumType.DIGITAL;
        this.stock = -1;
        this.quantityToAddToCart = 0;
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
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

    public int getQuantityToAddToCart() {
        return quantityToAddToCart;
    }
}
