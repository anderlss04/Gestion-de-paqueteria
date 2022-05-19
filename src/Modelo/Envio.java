package Modelo;

public class Envio {
	private String codigoSeguro;
	private String dniEmpleado;
	private String codigoEnvio;
	private String dniCliente;
	private String tipoEnvio;
	private String idTerminal;
	
	//METODOS GETTER AND SETTER
	public Envio(String codigoSeguro, String dniEmpleado, String codigoEnvio, String dniCliente, String tipoEnvio,
			String idTerminal) {
		super();
		this.codigoSeguro = codigoSeguro;
		this.dniEmpleado = dniEmpleado;
		this.codigoEnvio = codigoEnvio;
		this.dniCliente = dniCliente;
		this.tipoEnvio = tipoEnvio;
		this.idTerminal = idTerminal;
	}

	//METODOS GETTER AND SETTER
	public String getCodigoSeguro() {
		return codigoSeguro;
	}

	public void setCodigoSeguro(String codigoSeguro) {
		this.codigoSeguro = codigoSeguro;
	}

	public String getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public String getCodigoEnvio() {
		return codigoEnvio;
	}

	public void setCodigoEnvio(String codigoEnvio) {
		this.codigoEnvio = codigoEnvio;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getTipoEnvio() {
		return tipoEnvio;
	}

	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public String getIdTerminal() {
		return idTerminal;
	}

	public void setIdTerminal(String idTerminal) {
		this.idTerminal = idTerminal;
	}
	
	//METODOS
	
	
	

}
