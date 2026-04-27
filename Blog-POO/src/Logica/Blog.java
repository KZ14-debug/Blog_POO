package Logica;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Blog 
{
	
	private String nombre;
	private int codigoB;
	private String descripcion;
	private LocalDateTime fechaDeCreacion;
	private int codigoNumerico;
	private Map<Integer, Publicacion> publicaciones;
	
	
	
	public Blog(String nombre, String descripcion)
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		codigoB = codigoNumerico;
		codigoNumerico++;
		fechaDeCreacion = LocalDateTime.now();
		publicaciones = new TreeMap<Integer, Publicacion>();
		
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public LocalDateTime getFechaDeCreacion() {
		return fechaDeCreacion;
	}


	public int getCodigoB() {
		return codigoB;
	}
	
	public void crearPublicacion(String titulo, String texto, String autor)
	{
		Publicacion publi = new Publicacion(titulo, texto, autor);
		publicaciones.put(publi.getCodigoP(), publi);
		
	}
	
	
	private void revisarPublicacionExistente(int codigoP) throws Exception
	{
		if(!publicaciones.containsKey(codigoP))
		{
			throw new Exception("Codigo de publicacion no encontrado.");
		}
	}

	public String obtenerPublicacionyComentarios(int codigoP) throws Exception
	{
		revisarPublicacionExistente(codigoP);
		
		if(!publicaciones.containsKey(codigoP))
		{
			throw new Exception("Codigo de publicacion no encontrado");
		}
		
		Publicacion publi = publicaciones.get(codigoP);
		return publi.toString();
	}
	
	
	public Map<Integer, String> coleccionTitulosPublicaciones()
	{
		Map<Integer,String> titulos = new TreeMap<Integer, String>();
		
		for(Publicacion publi : publicaciones.values())
		{
			titulos.put(publi.getCodigoP(), publi.getTitulo());
		}
		
		return titulos;
	}
	
	public void agregarComentarioenPublicacion(int codigoP, String emailAutor, String direccionIP, String texto) throws Exception
	{
	
		
		revisarPublicacionExistente(codigoP);
		Publicacion publi = publicaciones.get(codigoP);
		publi.agregarComentario(emailAutor, direccionIP, texto);
		
	}
	
	
	public void borrarComentarioenPublicacion(int codigoP, int posicion) throws Exception
	{
		
		
		revisarPublicacionExistente(codigoP);
		Publicacion publi = publicaciones.get(codigoP);
		publi.borrarComentario(posicion);
	}
	
	public String toString()
	{
	    String resultado =  "Nombre: " + nombre + "\n" + "Codigo numerico: " + codigoB + "\n" + "Descripcion: " + descripcion + "\n"
	    + "Fecha de creacion: " + fechaDeCreacion.toString() + "\n";
	    
	    return resultado;
	}
}
