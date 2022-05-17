package fhv.musicshop;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
    @Consumes("application/json")
    public void addSongsToPlaylist(List<Song> songs, @HeaderParam("ownerId") String ownerId){
        PlaylistService playlistService = new PlaylistServiceImpl();
        playlistService.addSongsToPlaylist(ownerId, songs);
    }
}