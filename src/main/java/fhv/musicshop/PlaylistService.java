package fhv.musicshop;

import fhv.musicshop.domain.Playlist;
import fhv.musicshop.domain.Song;

import java.util.List;

public interface PlaylistService {
    void addSongsToPlaylist(String ownerId, List<Song> songs);
    Playlist getPlaylistByOwnerId(String ownerId);
    void createPlaylist(String ownerId);

}
