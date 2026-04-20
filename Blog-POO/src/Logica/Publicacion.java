package Logica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class Publicacion {
	
	private LocalDateTime fechaCreacion;
	private String titulo;
	private String autor;
	private String texto;
	private int codigo;
	private static int codigoNumerico = 0;
	private List<Comentario> comentarios;
	
	public Publicacion(String titulo, String texto, String autor)
	{
		codigo = codigoNumerico;
		codigoNumerico++;
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
		fechaCreacion = LocalDateTime.now();
		comentarios = new ArrayList<Comentario>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void agregarComentario(String emailAutor, String texto, String direccionIP)
	{
		Comentario coment = new Comentario(emailAutor, texto, direccionIP);
	}
	
	public void borrarComentario(int posicion)
	throws Exception
	{
		
		if(posicion < 0 || posicion >= comentarios.size()) //Esto verifica si se ingresa una posicion negativa o si se ingresa una posicion que es mayor o igual a la cantidad de comentarios que hay en la publicacion
		{
			throw new Exception("Comentario a eleiminar no exitente");
		}
		comentarios.remove(posicion);
	}
	
	public String toString()
	{
		String resultado = "Titulo: " + titulo + " - "
	            + "Fecha de publicacion: " + fechaCreacion.toString() + "\n"
	            + "Texto: " + texto + "\n"
	            + "Comentarios: ";

	    if (comentarios.isEmpty())
	    {
	        resultado += "No hay comentarios";
	    }
	    else
	    {
	        for (Comentario coment : comentarios)
	        {
	            resultado += coment.toString() + "\n";
	        }
	    }

	    return resultado;
				
	}
	
	
	

}
