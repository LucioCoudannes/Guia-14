
package libreria2.pkg0;

import Servicio.AutorService;
import Servicio.EditorialService;
import Servicio.LibroService;
import java.util.Scanner;


public class Menu {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    EditorialService es = new EditorialService();
    AutorService as = new AutorService();
    LibroService ls = new LibroService();
    
    public void Menu (){
        
        Integer op=0;
        
        
        do {
            
            System.out.println("Ingrese la opcion deseada");
            op = leer.nextInt();
            System.out.println("\n***********Menu******************");
            System.out.println("1- Mostrar Todos los Libros ");
            System.out.println("2- Buscar Libro por ISBN");
            System.out.println("3- Buscar Libro por Titulo");
            System.out.println("4- Buscar Libros por Autor");
            System.out.println("5- Buscar Libros por Editorial");
            System.out.println("6- Buscar Autor por Nombre");
            System.out.println("7- Alta de Nuevo Libro");
            System.out.println("8- Eliminar Libro");
            System.out.println("9- Modificar Libro");
            System.out.println("10- Alta Nuevo Cliente");
            System.out.println("11- Eliminar Autor");
            
            System.out.println("20- Salir");
            
            switch(op){
                
                case 1: ls.mostrarLibros();
                break;
                case 2: ls.buscarLibroxISBN();
                break;
                case 3: ls.buscarLibroxTitulo();
                break;
                case 4: ls.librosxAutor();
                break;
                case 5: ls.librosxEditorial();
                break;
                case 6: System.out.println("Ingrese el nombre del Autor");
                        String au = leer.next();
                        as.buscarAutorPorNombre(au);
                break;
                case 7: ls.crearLibro();
                break;
                case 8: ls.eliminarLibro();
                break;
                case 9:
                
                
                
            }
            
        } while (op!=20);
            
        
            
            
            
        
        
        
    }
      
    
    
    
}
