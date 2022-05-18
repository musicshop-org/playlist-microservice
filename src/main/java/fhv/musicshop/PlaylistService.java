package fhv.musicshop;

import fhv.musicshop.domain.Playlist;
import fhv.musicshop.domain.Song;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    void addSongsToPlaylist(String ownerId, List<Song> songs);
    Optional<Playlist> getPlaylistByOwnerId(String ownerId);
}
