package Interfaz;

import paqueteControl.Control;
import java.util.Scanner;
import java.util.Map;



public class EjemploBlog 
{
	

	public static void menuBlogs(Control control, Scanner in, int blogEnUso) throws Exception
	{
		int opc = 0;


		System.out.println("*-*-*-*-*-*-* MENU del blog *-*-*-*-*-*-* \n");

		while(opc != 3)
		{
			
			
			System.out.println("¿Que cambio quiere hacer en el blog? \n");
			
			System.out.println("1. Crear publicacion");
			System.out.println("2. Ver publicaciones");
			System.out.println("3. Regresar");
			
			System.out.println("\n Opcion: ");
			opc = in.nextInt();
			in.nextLine();

			
			switch(opc)
			{
			
				case 1:
					try {
						
						System.out.println("Ingrese los siguientes datos para su publicacion.\n");
						
						System.out.print("Autor: ");
						String autor = in.nextLine();

						System.out.print("Titulo: ");
						String titulo = in.nextLine();
						
						System.out.print("Texto: ");
						String texto = in.nextLine();

						control.crearPublicacion(blogEnUso, autor, texto, titulo);

						System.out.println("\n Publicacion creada con exito.");
						
					}
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
					break;

					
					
				case 2:
					
					menuPublicaciones(control, in, blogEnUso);
					break;

					
					
				case 3:
					
					System.out.println("Regrsando a la publicacion");
					break;

					
				default:
					System.out.println("Opcion no valida");
			}

		} 
	}
	
	
	
	
	
	
	public static void menuPublicaciones(Control control, Scanner in, int blogEnUso) throws Exception
	{
		
		int opc = 0;
		
		do
		{
			try
			{
				
				Map<Integer, String> publicaciones = control.obtenerPublicaciones(blogEnUso);

				
				if(publicaciones.isEmpty())
				{
				
					System.out.println("No tienes publicaciones.");
				
				}
			
				else
				{
				
					for(Integer codigo : publicaciones.keySet())
					{
						System.out.println(codigo + " --> " + publicaciones.get(codigo));
					}
				
				}
				
			}
			
			
			catch(Exception e)
			{
				System.out.println("Error:" + e);
			}
			
		
			System.out.println("1. Ver publicacion.");
			System.out.println("2. Regresar.");
			
			System.out.println("\n Opcion: ");
		
			opc = in.nextInt();
			in.nextLine();
			
			
			switch(opc)
			{
		
				case 1:
			
					try {
						
						System.out.print("Ingrese el codigo de la publicacion: ");
						int publicacionActual = in.nextInt();
						in.nextLine();

						AccionesdeComentarios(control, in, blogEnUso, publicacionActual);
						
					}
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
					break;
				
				
				case 2:
					System.out.println("Regresando...");
					break;
				

				default:
					System.out.println("Opcion invalida.");
			}
		

		} while(opc != 2);
		
	}
	
	
	
	public static void AccionesdeComentarios(Control control, Scanner in, int blogEnUso, int publicacionActual)
	{
		
		int opc = 0;
		
		do
		{
			
			try
			{
				
				System.out.println(control.obtenerPublicacion(blogEnUso, publicacionActual));
			
			}
			
			
			catch(Exception e) 
			{
				System.out.println(e.getMessage());
				return; 
			}
			
			
			
			
			System.out.println("Opciones: \n");
			System.out.println("1. Agregar comentario");
			System.out.println("2. Eliminar comentario");
			System.out.println("3. Regresar");
			
			System.out.println("\n Opcion:");
			opc = in.nextInt();
			in.nextLine();
			
			
			switch(opc)
			{
			
				case 1:
					
					try {
						
						System.out.print("Ingrese su email y direccion ip: \n");
						
						System.out.println("Email:");
						String email = in.nextLine();
						
						System.out.println("Direccion IP:");
						String direccionIP = in.nextLine();
						
						System.out.println("\n");


						System.out.println("Comentario:");
						String texto = in.nextLine();

						control.agregarComentario(blogEnUso, publicacionActual, email, direccionIP, texto);

					}
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
					break;
					
				case 2:
					
					try
					{
						
						System.out.println("Ingrese la posicion del comentario a eliminar.\n");
						
						int posicion = in.nextInt();
						in.nextLine();
						
						control.borrarComentario(blogEnUso, publicacionActual, posicion);
						
					}
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
					break;
					
					
				case 3:
					
					System.out.println("Regresando.");
					break;
					
					
				default:
					System.out.println("Opcion invalida.");
			
			}
			
			
		} while(opc != 3);
		
	}
	
	
	
	
	
	
	
	public static void menuPrincipal(Control control, Scanner in)
	{
		
		int opc = 0;
		
		do 
		{
			
			
			System.out.println("*-*-*-*-*-*-*-*-*-*-* Menu *-*-*-*-*-*-*-*-*-*-* \n");
			
			try
			{
				
				Map<Integer, String> blogs = control.obtenerBlogs();
				
				if(blogs.isEmpty())
				{
				
					System.out.println("No has creado blogs.");
				
				}
			
				else
				{
				
					for(Integer codigo : blogs.keySet())
					{
						System.out.println(codigo + " --> " + blogs.get(codigo));
					}
				
				}
				
			}
			
			
			catch(Exception e)
			{
				System.out.println("Error:" + e);
			}
			
			System.out.println("------------------------------------------------");
			System.out.println("\n");
			System.out.println("1. Crear blog");
			System.out.println("2. Seleccionar blog");
			System.out.println("3. Borrar blog");
			System.out.println("4. Salir");
			
			System.out.println("Opcion: ");
			opc = in.nextInt();
			in.nextLine();
			
			
			switch(opc)
			{
			
				case 1:
					
					try {
						
						System.out.print("Ingrese los siuientes datos: \n");
						
						System.out.println("Nombre del blog: ");
						String nombre = in.nextLine();
						
						System.out.println("Descripcion: ");
						String descripcion = in.nextLine();

						control.crearBlog(nombre, descripcion);
						
					}
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
					break;
					
					
				case 2:
					
					try {
						
						System.out.print("Ingrese el codigo del blog a trabajar: \n");
						
						int blogEnUso = in.nextInt();
						in.nextLine();
		

						menuBlogs(control, in, blogEnUso);
						
					}
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
					break;
					
					
					
				case 3:
					
					try {
						
						System.out.print("Ingrese los siuientes datos para borrar el blog: \n");
						
						System.out.println("Codigodel blog: ");
						int codigo = in.nextInt();
						in.nextLine();
						
						
						control.borrarBlog(codigo);
						
						System.out.println("El blog fue borrado con exito");
						
					}
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
					break;
					
					
				case 4:
					System.out.println("Saliendo");
					break;

					
				default:
					System.out.println("Opcion no valida.");
			
			}
			
			
			
			
		} while(opc != 4);
		
	}
	
	
	public static void main(String[] args)
	{
		Control control = new Control(); 
		
		Scanner in = new Scanner(System.in);

		menuPrincipal(control, in);

	}
}
