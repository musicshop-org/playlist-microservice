package fhv.musicshop;

import io.quarkus.hibernate.orm.panache.Panache;

import javax.transaction.Transactional;
import java.util.List;

public class PlaylistServiceImpl implements PlaylistService{

    @Override
    public void addSongsToPlaylist(String ownerId, List<Song> songs) {
        Playlist playlist = Playlist.findByOwnerId(ownerId);
        for (Song s: songs) {
            playlist.addSong(s);
        }
    }

    @Override
    public Playlist getPlaylistByOwnerId(String ownerId) {
        Playlist result = Playlist.findByOwnerId(ownerId);
        //result.getSongs().get(1).ge
        return result;
    }

    @Override
    public void createPlaylist(String ownerId) {
        Playlist playlist = new Playlist(ownerId);
        playlist.persist();

    }

}
