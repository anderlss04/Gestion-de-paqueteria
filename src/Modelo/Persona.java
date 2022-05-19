package Modelo;

public class Persona {
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String dni;
	private String cod_postal;
	private String direccion;
	
	//CONSTRUCTOR
	public Persona(String nombre, String apellido, String telefono, String email, String dni,
			String cod_postal, String direccion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.dni = dni;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido1) {
		this.apellido = apellido1;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
	
	//METODOS
	
	
}
