/**
 * 
 */
package info.pello.maven.hibernate.HibernateSamples;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * implementation of roleDAOInterface
 * @author Pello Xabier Altadill Izura
 * @greetz Blue mug
 *
 */
public class RoleDAO implements RoleDAOInterface {

	/* 
	 * selects one role by Id
	 * @param id
	 * @return Role
	 */
	public Role selectById(long id) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    Role role = (Role) session.get(Role.class, id);
	    session.close();
	    return role;
	}

	/*
	 * retrieves all roles from db
	 * @return List of roles
	 */
	public List<Role> selectAll() {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	 
	    List<Role> roles = session.createQuery("from Role").list();
	    session.close();
	    return roles;
	}

	/*
	 * inserts a new role in database
	 * retrieves generated id and sets to role instance
	 * @param new role
	 */
	public void insert(Role role) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	 
	    Long id = (Long) session.save(role);
	    role.setId(id);
	         
	    session.getTransaction().commit();
	         
	    session.close();

	}

	/*
	 * updates role
	 * @param role to update
	 */
	public void update(Role role) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
		    Session session = sessionFactory.openSession();
		 
		    session.beginTransaction();
		 
		    session.merge(role);
		 
		    session.getTransaction().commit();
		 
		    session.close();
	}

	/*
	 * delete given role
	 * @param role to delete
	 */
	public void delete(Role role) {
	    SessionFactory sessionFactory = HibernateSession.getSessionFactory();
	    Session session = sessionFactory.openSession();
	    
	    session.beginTransaction();
	    
	    session.delete(role);
	 
	    session.getTransaction().commit();
	 
	    session.close();
	}

}
