/**
 * 
 */
package info.pello.jomework;


/**
 * Represents User entity
 * @author Pello Xabier Altadill Izura
 * @greet to teachers who are users too
 */
public class User {
	private Long id;
	private String login;
	private String password;
	private String description;
	
	/**
	 * default constructor
	 */
	public User () {
		
	}

	
	/**
	 * @param id
	 * @param name
	 * @param password
	 * @param description
	 */
	public User(Long id, String login, String password, String description) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.description = description;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User> [id=" + id + ", login=" + login + ", password=" + password
				+ ", description=" + description + "]";
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	


	
	
}
