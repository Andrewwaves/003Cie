package es.ascender.biblioteca.negocio;

public class Direccion {
	
	private String dni;
	private String calle;
	private String numero;
	private String codigopostal;
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCodigopostal() {
		return codigopostal;
	}
	public void setCodigopostal(String codigopostal) {
		this.codigopostal = codigopostal;
	}
	public Direccion(String dni, String calle, String numero, String codigopostal) {
		super();
		this.dni = dni;
		this.calle = calle;
		this.numero = numero;
		this.codigopostal = codigopostal;
	}
	public Direccion() {
		super();
	}
	public Direccion(String calle, String numero) {
		super();
		this.calle = calle;
		this.numero = numero;
	}
	
	

}
