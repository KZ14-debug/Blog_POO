package paqueteControl;
import java.util.Map;
import Logica.Blog;
import java.util.TreeMap;


public class Control {

	private Map<Integer, Blog> blogs;
	
	public Control()
	{
		blogs = new TreeMap<Integer, Blog>();
		
		try {
			
			crearBlog("Blog 1", "¿Que es el One Piece?");
			crearBlog("Blog 2", "Poses de bizarras");

			
			for(Integer codigoB : blogs.keySet())
			{

				if(codigoB == 0)
				{
					crearPublicacion(codigoB, "OrewaKing", "Considerando que el anime y el manga de One Piece a estado teniendo multiples teorias sobre que es el gran tesosro"
							+ " que hara que quien lo encuentre se convertira en el rey de los piratas y que muchas de esas teorias apesar de sonar tan convincentes aun nadie"
							+ " considera 100% correcta alguna de esas teorias asi que me gustaria dejar mi teoria y ver que consideran ustedes sobre ella. La teoria que vengo"
							+ " a plantear es ¿ Y si el One Piece es en realidad una histroia escrita por el primer pirata JoyBoy donde relata lo que el cree que pasara en el"
							+ " futuro despues de su muerte? Esa es mi teoria y considero que puede llegar a ser muy convincente. ",  "Mi One Piece");
					
					
					crearPublicacion(codigoB, "OrewaKing", "El decir que el One Piece son los amigos es un chiste muy recurrente","Nakamas");

					
					Map<Integer, String> publicacion = obtenerPublicaciones(codigoB);

					
					for(Integer codigoP : publicacion.keySet())
					{
						
						agregarComentario(codigoB, codigoP, "Burroespacial365.com", "2023.234.200", "Yo opino que el One Pice son los amigos que hicimos en el camino.");
						agregarComentario(codigoB, codigoP, "Don_X@.com", "2023.123.130", "Ta buena la teoria.");
						
					}
				}
				
				else
				{
					crearPublicacion(codigoB, "Worldio", "Considero que el creador de JOJO's estaba adelantado a su epoca y que tiene buenos tanto "
							+ "para crear moda como de musica. ",  "Very Very Nice");
					
					
					crearPublicacion(codigoB, "StarFan", "Considero que muchos de los fans deberian analizar si el nombre que se pone al "
							+ "stand encaja ya sea con su apariencia o con su habilidad porque más de uno se llevara una sorpresa al ver "
							+ "grandes similitudes ya sea el album, banda o cancion con el stand que tiene el mismo nombre.","Si es una buena referencia");

					
					Map<Integer, String> publicacion = obtenerPublicaciones(codigoB);

					
					for(Integer codigoP : publicacion.keySet())
					{
						
						agregarComentario(codigoB, codigoP, "Solosequenose12302L@.com", "34.234.134", "Pose, pose, pose !!!");
						agregarComentario(codigoB, codigoP, "ASFD@startara.com", "2433.25.42", "Si me lleve varias sorpresas al hacer la prueba.");
						
					}
				}
				
			}
		}
		
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
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
