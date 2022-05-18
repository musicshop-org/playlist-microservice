package fhv.musicshop;

import fhv.musicshop.domain.Playlist;
import fhv.musicshop.domain.Song;

import java.util.List;
import java.util.Optional;

public class PlaylistServiceImpl implements PlaylistService{

    @Override
    public void addSongsToPlaylist(String ownerId, List<Song> songs) {
        Optional<Playlist> playlistOpt = Playlist.findByOwnerId(ownerId);
        Playlist playlist;
        if (playlistOpt.isEmpty()){
            playlist = new Playlist(ownerId);
            playlist.persist();
        }else{
            playlist = playlistOpt.get();
        }

        for (Song s: songs) {
            playlist.addSong(s);
        }
    }

    @Override
    public Optional<Playlist> getPlaylistByOwnerId(String ownerId) {
        return Playlist.findByOwnerId(ownerId);
    }

}
