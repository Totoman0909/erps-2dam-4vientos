

import java.util.List;


public interface JugadorDAO {
	

	/**
	 * Used to save or update a user.
	 */
	public void guardarOActualizarJugador(Jugador jugador);
	
	public void eliminarJugador(Long id);
	
	public List<Jugador> listarJugadores();
	
	public Jugador listarJugadorPorId(Long id);
	}
