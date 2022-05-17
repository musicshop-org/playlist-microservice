package fhv.musicshop;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
public class Playlist extends PanacheEntity {

    private String ownerId;
    @ManyToMany
    private List<Song> songs;

    public Playlist(String ownerId) {
        this.ownerId = ownerId;
        this.songs = new LinkedList<>();
    }

    public Playlist() {

    }

    public static Playlist findByOwnerId(String ownerId){
        return find("ownerId",ownerId).firstResult();
    }

    public void addSong(Song song){
        songs.add(song);
    }
}
