package Logica;

import java.time.LocalDateTime;

class Comentario {
	
	private String emailAutor;
	private String texto;
	private LocalDateTime fecha;
	private String direccionIP;
	
	public Comentario(String emailAutor, String texto, String direccionIP)
	{
		this.emailAutor = emailAutor;
		this.texto = texto;
		this.direccionIP = direccionIP;
		fecha = LocalDateTime.now();
		
	}

	public String getEmailAutor() {
		return emailAutor;
	}

	public void setEmailAutor(String emailAutor) {
		this.emailAutor = emailAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getDireccionIP() {
		return direccionIP;
	}
	
	public String toString()
	{
		String resultado= "Email: " + emailAutor + " - "
	            + "Fecha de publicacion: " + fecha.toString() + "\n"
	            + "Comentario: " + texto + "\n";
		
		return resultado;
	}
	

}
