/**
 * 
 */
package info.pello.playlist.controllers;

import info.pello.playlist.Playlist;
import info.pello.playlist.PlaylistDAO;

import java.util.Map;

//import javax.inject.Inject;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * controller for playlist REST resource
 * @author Pello Xabier Altadill Izura	
 * @greetz 4 u as always
 */
@Controller
@RequestMapping("/playlist")
public class PlaylistController {
	
	private PlaylistDAO playlistDAO;
	
	//@Inject
	public void getPlaylistDAO (PlaylistDAO playlistDAO) {
		this.playlistDAO = playlistDAO;
	}
	
	/**
	 * handles default / or /hello request
	 * @param model
	 * @return the name of the view to show
	 * RequestMapping({"/","/home"})
	 * other possible config
	 * public String sayHelloPage(@PathVariable int id ,Map<String, Object> model) {
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String getPlaylist(@PathVariable("id") int id ,Model model) {
		Playlist playlist = playlistDAO.getplaylistsById(id);
		model.addAttribute(playlist);
		
		// We return view name
		return "playlist/view";
	}

	/**
	 * PUT, updates a playlist
	 * @param id
	 * @param playlist
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void putPlaylist(@PathVariable("id") int id, Playlist playlist) {
		playlistDAO.update(playlist);
	}
	
	/**
	 * POST, creates a new playlist
	 * @param playlist
	 * @param result
	 * @param respone
	 * @throws BindException
	 */
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Playlist createPlaylist(Playlist playlist, BindingResult result, HttpServletResponse response)  {
		if (result.hasErrors()) {
			// TODO
			// We have to add @Valid to Playlist 
			// In case of error we enter here
		}
		
		playlistDAO.create(playlist);
		response.setHeader("Location","/playlist/"+playlist.getId());
		return playlist;
	}
	
	/**
	 * DELETE method for resource deletion
	 * @param id
	 */
	@RequestMapping(value="/id",method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePlaylist(@PathVariable("id") int id) {
		playlistDAO.delete(id);
	}
	
}
