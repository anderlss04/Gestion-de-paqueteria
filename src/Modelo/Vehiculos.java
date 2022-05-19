package Modelo;

public class Vehiculos {
	private String matricula;
	private String estado;
	private String a�o;
	private String capacidad;
	private String modelo;
	private String marca;
	
	//CONSTRUCTOR
	public Vehiculos(String matricula, String estado, String a�o, String capacidad, String modelo, String marca) {
		super();
		this.matricula = matricula;
		this.estado = estado;
		this.a�o = a�o;
		this.capacidad = capacidad;
		this.modelo = modelo;
		this.marca = marca;
	}
	
	//METODOS GETTER AND SETTER
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getA�o() {
		return a�o;
	}

	public void setA�o(String a�o) {
		this.a�o = a�o;
	}

	public String getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	
}
