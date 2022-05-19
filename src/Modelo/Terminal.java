package Modelo;

public class Terminal {
	private String nombre;
	private String id_terminal;
	private String cod_postal;
	private String direccion;
	
	//CONSTRUCTOR
	public Terminal(String nombre, String id_terminal, String cod_postal, String direccion) {
		super();
		this.nombre = nombre;
		this.id_terminal = id_terminal;
		this.cod_postal = cod_postal;
		this.direccion = direccion;
	}

	//METODOS GETTER AND SETTER
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId_terminal() {
		return id_terminal;
	}

	public void setId_terminal(String id_terminal) {
		this.id_terminal = id_terminal;
	}

	public String getCod_postal() {
		return cod_postal;
	}

	public void setCod_postal(String cod_postal) {
		this.cod_postal = cod_postal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
