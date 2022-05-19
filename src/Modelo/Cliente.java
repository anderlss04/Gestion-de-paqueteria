package Modelo;

public class Cliente extends Persona{
	private String fechaRegistro;
	
	//CONSTRUCTOR
	public Cliente(String nombre, String apellido, String telefono, String email, String dni,
			String cod_postal, String direccion, String fechaRegistro) {
		super(nombre, apellido, telefono, email, dni, cod_postal, direccion);
		this.fechaRegistro = fechaRegistro;
	}

	
	//METODOS GETTER AND SETTER
	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	

}
