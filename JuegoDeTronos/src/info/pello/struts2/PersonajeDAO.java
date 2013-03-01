package info.pello.struts2;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class PersonajeDAO {
	
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	

	/**
	 * Used to save or update a user.
	 */
	public void guardarOActualizarPersonaje(Personaje personaje) {
		try {
			session.saveOrUpdate(personaje);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	public void eliminarPersonaje(Long id) {
		try {
			Personaje personaje = (Personaje) session.get(Personaje.class, id);
			session.delete(personaje);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	public List<Personaje> listarPersonajes(){
		List<Personaje> personajes = null;
		try {
			personajes = session.createQuery("from Personaje").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personajes;
	}

	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	public List<Personaje> listarPersonajesCasa(String casa){
		List<Personaje> personajes = null;
		System.out.println("Casa: " + casa);
		try {
			String hql = "from Personaje p where p.casa = :casa";
			personajes = session.createQuery(hql)
			.setParameter("casa", casa)
			.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personajes;
	}
	
	/**
	 * Used to list a single user by Id.
	 */
	public Personaje listarPersonajePorId(Long id) {
		Personaje personaje = null;
		try {
			personaje = (Personaje) session.get(Personaje.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personaje;
	}

}
