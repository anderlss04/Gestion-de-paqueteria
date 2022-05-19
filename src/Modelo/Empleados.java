package Modelo;

public class Empleados extends Persona {
	private String terminal;
	private String cargo;
	private String encargado;
	
	//CONSTRUCTOR
	public Empleados(String nombre, String apellido, String telefono, String email, String dni,
			String cod_postal, String direccion, String terminal, String cargo, String encargado) {
		super(nombre, apellido, telefono, email, dni, cod_postal, direccion);
		this.terminal = terminal;
		this.cargo = cargo;
		this.encargado = encargado;
	}

	//METODOS GETTER AND SETTER
	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	
	//METODOS
	
	
	
	
	
}
