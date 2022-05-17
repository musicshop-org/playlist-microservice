package fhv.musicshop;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Path("playlist-api")
public class RestController {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Welcome to the playlist-microservice :)";
    }

    @GET
    @Path("/playlist/{ownerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Playlist getPlaylistByOwnerId(@PathParam("ownerId") String ownerId) {
        PlaylistService playlistService = new PlaylistServiceImpl();
        return playlistService.getPlaylistByOwnerId(ownerId);
    }

    @POST
    @Path("/playlist/addSongs")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean addSongsToPlaylist(List<Song> songs, @HeaderParam("ownerId") String ownerId){
        PlaylistService playlistService = new PlaylistServiceImpl();
        playlistService.addSongsToPlaylist(ownerId, songs);
        return true;
    }

    @POST
    @Path("/playlist/createPlaylist")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public boolean createPlaylistForOwnerId(String ownerId) {
        PlaylistService playlistService = new PlaylistServiceImpl();
        playlistService.createPlaylist(ownerId);
        return true;
    }

    @GET
    @Path("/playlist/{ownerId}")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public boolean test(){
        Artist artist = new Artist("TestArtist");
        Album album = new Album("testAlbum", LocalDate.now(), UUID.randomUUID(), "testLabel");
        Song song = new Song("Testsong", LocalDate.now(), "testGenre", List.of(artist), Set.of(album));

        song.persist();
        return true;
    }
}