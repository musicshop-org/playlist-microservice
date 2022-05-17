package fhv.musicshop;

import javax.transaction.Transactional;
import java.util.List;

public class PlaylistServiceImpl implements PlaylistService{

    @Override
    @Transactional
    public void addSongsToPlaylist(String ownerId, List<Song> songs) {
        Playlist playlist = Playlist.findByOwnerId(ownerId);
        for (Song s: songs) {
            playlist.addSong(s);
        }
        playlist.persist();
    }

    @Override
    @Transactional
    public Playlist getPlaylistByOwnerId(String ownerId) {
        return Playlist.findByOwnerId(ownerId);
    }

    @Override
    @Transactional
    public void createPlaylist(String ownerId) {
        Playlist playlist = new Playlist(ownerId);
        playlist.persist();

    }

}
