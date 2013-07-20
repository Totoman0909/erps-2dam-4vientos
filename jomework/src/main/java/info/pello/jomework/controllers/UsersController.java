/**
 * 
 */
package info.pello.jomework.controllers;

import info.pello.jomework.User;
import info.pello.jomework.UserDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * controller to show the users page
 * @author Pello Xabier Altadill Izura	
 * @greetz 4 u as always
 */
@Controller
public class UsersController {
	private UserDAO userDAO;
	
	/**
	 * constructor with autowired parameter
	 * Spring will inject this
	 * @param userDAO
	 */
	@Autowired
	public UsersController (UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	/**
	 * handles default / or /hello request
	 * @param model
	 * @return the name of the view to show
	 * RequestMapping({"/users","/users/show"})
	 */
	@RequestMapping(method=RequestMethod.GET,value={"/users","/users/show"})
	public String showUsers(@RequestParam(value="user", defaultValue="", required=false) String name,Map<String, Object> model) {
		System.err.println("En show Users, nos han pasado: " + name);
		if (null == this.userDAO) {		System.out.println("Hutsa dek");}
		//List<User> users = this.userDAO.getUsers();
		//model.put("users", users);

		// We return view name
		return "users";
	}

	/**
	 * handles default / or /hello request
	 * @param model
	 * @return the name of the view to show
	 * RequestMapping({"/users","/users/show"})
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String createUser(Map<String, Object> model) {
		//System.err.println("Form bidalita ." + model.get("user").toString());
		//
		//List<User> users = this.userDAO.getUsers();
		//model.put("users", users);

		// We return view name
		return "users";
	}

}
