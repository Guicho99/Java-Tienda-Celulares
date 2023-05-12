package mx.com.cursodia.js18.mod1.sem3;



import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TiendaTelcel {
	
	ArrayList<Articulo> almacen = new ArrayList<Articulo>();
	public static void main(String[] args) 
	
	{
		TiendaTelcel tt = new TiendaTelcel();
		tt.mainMenu();

	}

	/*
	 * 
	 * 	Metodo de Impresion de datos Con el 
	 * 	
	 * 		.nextLine();
	 * 			.nextInt();
	 * 				.nextFloat();
	 * 
	 * 	Recaudar informacion del usuario con el metodo:
	 * 		Scanner sc = new Scanner(System.in);
	 * 
	 * private void leerArticulos()
	*	{
	*		Scanner sc = new Scanner(System.in);
	*		System.out.println("Cuantos articulos generara?");
	*		int n = sc.nextInt();
	*	
	*		Articulo[] almacen = new Articulo[n];
	*	
	*		System.out.println("Cve: ");
	*		int cve = sc.nextInt();
	*		System.out.println("Categoria: ");
	*		String cat = sc.nextLine();
	*		System.out.println("Nombre: ");
	*		String nom = sc.nextLine();
	*		System.out.println("Precio: ");
	*		float pre = sc.nextFloat();
	*		System.out.println("Inventario: ");
	*		int inv = sc.nextInt();
	*	}
	 */
	
	/*
	 * La clase leer Articulos ofrece
	 * 	Cambio de tipos de variables con los metodos;
	 * 
	 * 		Integer.parseInt(sc.nextLine());
	 * 			Float.parseFloat(sc.nextLine());
	 * 
	 * Interaccion y recolecion de datos con el ususario medinate
	 * una ventanan emergente usado el metodo
	 * 
	 * 		JOptionPane.showInputDialog();
	 * 				
	 */
	private void mainMenu()
	{
		int op = Integer.parseInt(JOptionPane.showInputDialog("------------- Tienda Telcel ------------- \n"
                + "Slecciona una accion a realizar           \n"
				  + "1. Agregar Artiuculos\n"
                + "2. Imprimir Articulos\n"
				  + "3. Actualizar un Articulo\n"
                + "4. Borrar un Articulo\n"
				  + "5. Salir"));
		switch(op) 
		{
			case 1:
			{
				leerArticulos();
			}
			case 2:
			{
				imprimirArticulos();
			}
			case 3:
			{
				if(almacen.size()!=0)
				{
					actualizarArticulos();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Aun no se agregado ningun articulo");
				}
				mainMenu();
				
			}
			case 4:
			{
				if(almacen.size()!=0)
				{
					borrarArticulos();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Aun no se agregado ningun articulo");
				}
				mainMenu();
			}
			case 5:
			{
				System.exit(0); 
			}
		}
	} 
	private void leerArticulos()
	{
		
		int op;
		do
		{
			int cve = Integer.parseInt(JOptionPane.showInputDialog("Cve: "));
			String cat = JOptionPane.showInputDialog("Categoria: ");
			String nom = JOptionPane.showInputDialog("Nombre: ");
			float pre = Float.parseFloat(JOptionPane.showInputDialog("Precio:  "));
			int inv = Integer.parseInt(JOptionPane.showInputDialog("Inventario: "));
			almacen.add(new Articulo(cve,cat,nom,pre,inv));
			op = Integer.parseInt(JOptionPane.showInputDialog("Agregar otro articulo? 1. Si 2.No"));
		}while(op != 2);
		
		mainMenu();
	}
	
	private void imprimirArticulos()
	{
		System.out.println("Clave\t\tCategoria\t\tNombre\t\tPrecio\t\tExist");
		for(Articulo A:almacen)
		{
			System.out.println(A);
		}
		mainMenu();
	
	}
	private void actualizarArticulos()
	{
		int  cvea = Integer.parseInt(JOptionPane.showInputDialog("Inserte la Cve del articulo a modificar"));
		
		
		for(Articulo A: almacen)
		{
			if(A.cve_art == cvea)
			{
				A.cve_art = Integer.parseInt(JOptionPane.showInputDialog("Nuevo Cve: "));
				A.cat_art = JOptionPane.showInputDialog("Nuevo Categoria: ");
				A.nom_art = JOptionPane.showInputDialog("Nuevo Nombre: ");
				A.pre_art = Float.parseFloat(JOptionPane.showInputDialog("Nuevo Precio:  "));
				A.inv_art = Integer.parseInt(JOptionPane.showInputDialog("Nuevo Inventario: "));
				break;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No se ay un articulo con esa clave");
				
			}
		}
		mainMenu();
	}
	
	private void borrarArticulos()
	{
		int  cvea = Integer.parseInt(JOptionPane.showInputDialog("Inserte la Cve del articulo a eliminar"));
		
			for(Articulo A: almacen)
			{
				if(A.cve_art == cvea)
				{
					if(almacen.size()==1)
					{
						almacen.clear();
						break;
					}
					else
					{
						almacen.remove(A);
					}				
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No se ay un articulo con esa clave");
					
				}
			}
		
		mainMenu();
	}
	
}
