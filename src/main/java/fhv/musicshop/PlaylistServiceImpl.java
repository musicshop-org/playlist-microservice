package fhv.musicshop;

import fhv.musicshop.domain.Playlist;
import fhv.musicshop.domain.Song;

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
        return Playlist.findByOwnerId(ownerId);
    }

    @Override
    public void createPlaylist(String ownerId) {
        Playlist playlist = new Playlist(ownerId);
        playlist.persist();
    }

}
