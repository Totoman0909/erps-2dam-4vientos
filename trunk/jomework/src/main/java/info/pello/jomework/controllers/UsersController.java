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
import org.springframework.web.servlet.ModelAndView;

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
	 * handles default /users or /users/show
	 * optional get parameter: url?user=foo
	 * @param model
	 * @return the name of the view to show
	 * RequestMapping({"/users","/users/show"})
	 */
	@RequestMapping(method=RequestMethod.GET,value={"/users","/users/show"})
	public String showUsers(@RequestParam(value="user", defaultValue="", required=false) String name,Map<String, Object> model) {
		System.err.println("Parameter: " + name);
		if (null == this.userDAO) {		System.out.println("Hutsa dek");}
		List<User> users = this.userDAO.getUsers();
		model.put("users", users);

		// We return view name
		return "users";
	}
	
	/**
	 * handles default /users/detail?user=id
	 * optional get parameter: url?user=foo
	 * @param model
	 * @return the name of the view to show
	 * RequestMapping({"/users/detail"})
	 */
	@RequestMapping(method=RequestMethod.GET,value={"/users/detail"})
	public String userDetail(@RequestParam(value="iduser", defaultValue="", required=true) Long id,Map<String, Object> model) {
		System.err.println("Parameter: " + id);
		User user = this.userDAO.getUsersById(id);
		model.put("user", user);

		// We return view name
		return "userdetail";
	}
	
	/**
	 * handles /usera/new
	 * redirects to new user form
	 * @param model
	 * @return the name of the view to show
	 * RequestMapping({"/users","/users/new"})
	 */
	@RequestMapping(method=RequestMethod.GET,value={"/users/new"})
	public String newUser(Map<String, Object> model) {
		
		// We'll user an User entity
		model.put("user", new User());
		
		// We return view name
		return "newuser";
	}

	/**
	 * handles default /userrs req
	 * @param model
	 * @return the name of the view to show
	 * RequestMapping({"/users","/users/show"})
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView saveUser(User user) {

		System.err.println("Form received ." + user.toString());
		// We save the user:
		userDAO.create(user);
		
	    // We redirect to other handler
		ModelAndView modelAndView = new ModelAndView("redirect:/users");                
	    Map<String, Object> model = modelAndView.getModel();
	    
	    return new ModelAndView("redirect:/users", model); 
	    
				
	}

}
