package fhv.musicshop;

import fhv.musicshop.domain.Album;
import fhv.musicshop.domain.Artist;
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
            for (Artist artist: s.getArtists()) {
                Optional<Artist> existingArtist = Artist.find("name", artist.getName()).firstResultOptional();
                if(existingArtist.isEmpty()){
                    artist.persist();
                }
            }
            for (Album album: s.getInAlbum()) {
                Optional<Album> existingAlbum = Album.find("albumId", album.getAlbumId()).firstResultOptional();
                if(existingAlbum.isEmpty()){
                    album.persist();
                }
            }
            Optional<Song> existingSong = Song.find("id",s.getId()).firstResultOptional();
            if (existingSong.isEmpty()){
                s.persist();
            }
            playlist.addSong(s);
        }
    }

    @Override
    public Optional<Playlist> getPlaylistByOwnerId(String ownerId) {
        return Playlist.findByOwnerId(ownerId);
    }

}
