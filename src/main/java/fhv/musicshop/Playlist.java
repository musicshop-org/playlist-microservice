package fhv.musicshop;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Playlist extends PanacheEntity {

    private String ownerId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Song> songs;

    public Playlist(String ownerId) {
        this.ownerId = ownerId;
        this.songs = new LinkedList<>();
    }

    public Playlist() {
    }

    public static Playlist findByOwnerId(String ownerId){
        return find("ownerId", ownerId).firstResult();
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public String getOwnerId() {
        return ownerId;
    }

    public List<Song> getSongs() {
        return songs;
    }
}
