package info.pello.playlist;

import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


/**
 * DAO for playlist entity using Hibernate
 * @author Pello Xabier Altadill Izura
 * @greetz Blue Mug
 *
 */
@Repository  
public class PlaylistDAO {

	private SessionFactory sessionFactory;

	public PlaylistDAO () { System.out.println("Bean created");}


	/**
	 * gives hibernate3 Session
	 * @return current hibernate Session
	 */
	private Session getSession () {

		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * gets playlist data from DataBase
	 * @param playlistId
	 * @return
	 */
	@Transactional(readOnly = true)
	public Playlist getplaylistsById (Integer playlistId) {
	    Playlist playlist = (Playlist) getSession().get(Playlist.class, playlistId);
	    return playlist;
	} 

	/**
	 * gets all playlist data from DataBase
	 * @return list of playlists
	 */
	@Transactional(readOnly = true)
	public List<Playlist> getplaylists () {
		List<Playlist> playlists = null;
		try {
			playlists = getSession().createQuery("from playlist").list();
		} catch (Exception e) {
			System.err.println("Error e: " + e.getMessage() + ":");
			e.printStackTrace(System.out);
		}
	    return playlists;
	} 
	
	/**
	 * creates new playlist
	 * @param newplaylist
	 * @return
	 */
	@Transactional
	public long create (Playlist newplaylist) {

		//getSession().beginTransaction();
		 
		Integer id = (Integer) getSession().save(newplaylist);
	    newplaylist.setId(id);
	         
	    //getSession().getTransaction().commit();
	         
		return id;
	}
	
	/**
	 * updates playlist information 
	 * @param playlist
	 * @return affected rows
	 */
	@Transactional
	public int update (Playlist playlist) {
		
		getSession().merge(playlist);
		return 0;
	}
	
	/**
	 * delete playlist  
	 * @param playlistId
	 * @return affected rows
	 */
	@Transactional
	public int delete (Integer playlistId) {;
	    
		// It's easier to delete using the object.. but
		// just to see how we should delete by id:
	 	Playlist playlistToDelete = (Playlist) sessionFactory.getCurrentSession().load(Playlist.class,playlistId);
	 	getSession().delete(playlistToDelete);
		return 0;
	}

	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		System.out.println("Session factory is SET!!");

	}




}
