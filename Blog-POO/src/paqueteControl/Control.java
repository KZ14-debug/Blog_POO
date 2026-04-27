package paqueteControl;
import java.util.Map;
import Logica.Blog;
import java.util.TreeMap;


public class Control {

	private Map<Integer, Blog> blogs;
	
	public Control()
	{
		blogs = new TreeMap<Integer, Blog>();
	}
	
	public void crearBlog(String nombre, String descripcion)
	{
		Blog b = new Blog(nombre, descripcion);
		blogs.put(b.getCodigoB(), b);
	}
	
	public void borrarBlog(int codigoB) throws Exception
	{
		if(!blogs.containsKey(codigoB))
		{
			throw new Exception("El codigo de blog no es valido");
		}
		blogs.remove(codigoB);
	}
	
	public Map<Integer, String> obtenerBlogs()
	{
		Map<Integer, String> resultado = new TreeMap<Integer, String>();
		
		for(Blog b : blogs.values())
		{
			resultado.put(b.getCodigoB(), b.getNombre());
		}
		
		return resultado;
	}
	
	public void crearPublicacion(int codigoB, String nombre, String texto, String titulo) throws Exception
	{
		
		if(!blogs.containsKey(codigoB))
		{
			throw new Exception ("El codigo del blog no es valido");
		}
		
		Blog b = blogs.get(codigoB);
		b.crearPublicacion(nombre, texto, titulo);
		
	}
	
	
	public Map<Integer, String> obtenerPublicaciones(int codigoB) throws Exception
	{
		
		if(!blogs.containsKey(codigoB))
		{
			throw new Exception("El codigo del blog no es valido");
		}
		
		return blogs.get(codigoB).coleccionTitulosPublicaciones();
		
	}
	
	
	public String obtenerPublicacion(int codigoB, int codigoP) throws Exception
	{
		
		if(!blogs.containsKey(codigoB))
		{
			throw new Exception("El codigo del blog no es valido");
		}
		
		return blogs.get(codigoB).obtenerPublicacionyComentarios(codigoP);
		
	}
	
	
	public void agregarComentario(int codigoB, int codigoP, String emailAutor, String direccionIP, String texto) throws Exception
	{
		
		
		if(!blogs.containsKey(codigoB))
		{
			throw new Exception("El codigo del blog no es valido");
		}
		
		blogs.get(codigoB).agregarComentarioenPublicacion(codigoP, emailAutor, direccionIP, texto);
		
		
	}
	
	public void borrarComentario(int codigoB, int codigoP, int posicion) throws Exception
	{
		
		
		if(!blogs.containsKey(codigoB))
		{
			throw new Exception("El codigo del blog no es valido");
		}
		
		blogs.get(codigoB).borrarComentarioenPublicacion(codigoP, posicion);
		
		
		
	}
}
