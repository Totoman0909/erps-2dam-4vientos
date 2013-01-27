package info.pello.struts2;


public class Jugador {

	private Long id;
	private String nombre;
	private String puesto;
	private Long dorsal;
	private Long idequipo;
	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}


	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}


	/**
	 * @return the dorsal
	 */
	public Long getDorsal() {
		return dorsal;
	}


	/**
	 * @param dorsal the dorsal to set
	 */
	public void setDorsal(Long dorsal) {
		this.dorsal = dorsal;
	}


	/**
	 * @return the idequipo
	 */
	public Long getIdequipo() {
		return idequipo;
	}


	/**
	 * @param id_equipo the id_equipo to set
	 */
	public void setIdequipo(Long idequipo) {
		this.idequipo = idequipo;
	}



}
