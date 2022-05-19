package Modelo;

public class Factura {
	private String cod_envio;
	private String num_factura;
	private float precio;
	private String fecha_emision;
	private MetodoPago metodoPago;
	
	//CONSTRUCTOR
	public Factura(String cod_envio, String num_factura, float precio, String fecha_emision, MetodoPago metodoPago) {
		super();
		this.cod_envio = cod_envio;
		this.num_factura = num_factura;
		this.precio = precio;
		this.fecha_emision = fecha_emision;
		this.metodoPago = metodoPago;
	}

	//METODOS GETTER AND SETTER
	public String getCod_envio() {
		return cod_envio;
	}

	public void setCod_envio(String cod_envio) {
		this.cod_envio = cod_envio;
	}

	public String getNum_factura() {
		return num_factura;
	}

	public void setNum_factura(String num_factura) {
		this.num_factura = num_factura;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(String fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public String getMetodoPago() {
		return "";
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	
	
}
