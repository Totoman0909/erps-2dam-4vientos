package info.pello.struts2;




public class Personaje {

	private Long id;
	private String nombre;
	private String descripcion;
	private Integer sexo;
	private String casa;
	
    public Personaje () {
    	
    }
    
    public Personaje (Long id, String nombre) {
    	this.id = id;
    	this.nombre = nombre;
    }
		
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the sexo
	 */
	public Integer getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the casa
	 */
	public String getCasa() {
		return casa;
	}

	/**
	 * @param casa the casa to set
	 */
	public void setCasa(String casa) {
		this.casa = casa;
	}

	
	
}
