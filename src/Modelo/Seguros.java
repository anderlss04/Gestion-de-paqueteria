package Modelo;

public class Seguros {
	private String tipoSeguro;
	private String descripcion;
	private String codigo;
	
	//CONSTRUCTOR
	public Seguros(String tipoSeguro, String descripcion, String codigo) {
		super();
		this.tipoSeguro = tipoSeguro;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}

	//METODOS GETTER AND SETTER
	public String getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(String tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	

}
