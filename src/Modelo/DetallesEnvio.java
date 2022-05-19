package Modelo;

public class DetallesEnvio extends Envio{
	private String estado;
	private int numBultos;
	private float peso;
	private String destino;
	private String codPostal;
	private String destinatario;
	private String origen;
	private String fechaEnvio;
	private String fechaEntrega;
	
	//CONSTRUCTOR
	public DetallesEnvio(String codigoSeguro, String dniEmpleado, String codigoEnvio, String dniCliente,
			String tipoEnvio, String idTerminal, String estado, int numBultos, float peso, String destino,
			String codPostal, String destinatario, String origen, String fechaEnvio, String fechaEntrega) {
		super(codigoSeguro, dniEmpleado, codigoEnvio, dniCliente, tipoEnvio, idTerminal);
		this.estado = estado;
		this.numBultos = numBultos;
		this.peso = peso;
		this.destino = destino;
		this.codPostal = codPostal;
		this.destinatario = destinatario;
		this.origen = origen;
		this.fechaEnvio = fechaEnvio;
		this.fechaEntrega = fechaEntrega;
	}

	//METODOS GETTER AND SETTER
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNumBultos() {
		return numBultos;
	}

	public void setNumBultos(int numBultos) {
		this.numBultos = numBultos;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	@Override
	public String toString() {
		return "DetallesEnvio: \nEstado: " + estado + "\nNumero de Bultos: " + numBultos + "\nPeso: " + peso + "\nDestino: "
				+ destino + "\n Destinatario: " + destinatario + "\nFecha Envio:" + fechaEnvio
				+ "\nFecha Entrega: " + fechaEntrega;
	}
	
	
	
	
	
}
