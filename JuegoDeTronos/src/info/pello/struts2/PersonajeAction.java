package info.pello.struts2;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class PersonajeAction extends ActionSupport implements ModelDriven<Personaje> {

	private static final long serialVersionUID = -6659354552584240539L;

	
	private Personaje personaje = new Personaje();
	private List<Personaje> listaPersonajes = new ArrayList<Personaje>();
	private PersonajeDAO equipoDAO = new PersonajeDAO();

	
	@Override
	public Personaje getModel() {
		return personaje;
	}
	
	/**
	 * To save or update user.
	 * @return String
	 */
	public String guardarOActualizar()
	{	
		equipoDAO.guardarOActualizarPersonaje(personaje);
		return SUCCESS;
	}
	
	/**
	 * Nuevo personaje
	 * @return String
	 */
	public String nuevo()
	{
		return SUCCESS;
	}
	
	/**
	 * lista todos los personajes.
	 * @return String
	 */
	public String listar()
	{
		listaPersonajes = equipoDAO.listarPersonajes();
		return SUCCESS;
	}
	
	/**
	 * carga el formulario casas
	 * @return String
	 */
	public String casas()
	{
		return SUCCESS;
	}

	/**
	 * Al enviar el formulario de casas, hace la consulta y 
	 * muestra personajes en la jsp
	 * @return String
	 */
	public String listarPorCasa()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		listaPersonajes = equipoDAO.listarPersonajesCasa(request.getParameter("casa").toString());
		return SUCCESS;
	}
	
	/**
	 * To delete a user.
	 * @return String
	 */
	public String eliminar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		equipoDAO.eliminarPersonaje(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	/**
	 * To list a single user by Id.
	 * @return String
	 */
	public String editar()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		personaje = equipoDAO.listarPersonajePorId(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public List<Personaje> getListaPersonajes() {
		return listaPersonajes;
	}

	public void setListaPersonajes(List<Personaje> listaPersonajes) {
		this.listaPersonajes = listaPersonajes;
	}
	


}
