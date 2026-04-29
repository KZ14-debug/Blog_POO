package Interfaz;

import paqueteControl.Control;
import java.util.Scanner;
import java.util.Map;



public class EjemploBlog 
{
	

	public static void menuBlogs(Control control, Scanner scanner, int blogEnUso)
	{
		int opc = 0;
		Scanner in = new Scanner(System.in);
		
		


		while(opc != 3)
		{
			
			System.out.println("MENU del blog \n");
			System.out.println("¿Que desea realizar?");
			System.out.println("1. Crear publicacion");
			System.out.println("2. Ver publicaciones");
			System.out.println("3. Regresar");
			
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

						System.out.println("Publicacion creada con exito.");
						
					}
					
					catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
					break;

					
					
				case 2:
					
					menuPublicaciones(control, scanner, blogEnUso);
					break;

					
					
				case 3:
					
					System.out.println("Regrsando a la publicacion");
					break;

					
				default:
					System.out.println("Opcion no valida");
			}

		} 
	}
	
	
	
	
	
	
	public static void menuPublicaciones(Control control, Scanner scanner, int blogEnUso)
	{
		
		
		
	}
	
}
