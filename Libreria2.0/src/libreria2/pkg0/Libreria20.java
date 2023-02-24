package libreria2.pkg0;

import Servicio.AutorService;
import Servicio.EditorialService;
import Servicio.LibroService;
import java.util.Scanner;

public class Libreria20 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        AutorService as = new AutorService();
        EditorialService es = new EditorialService();
        LibroService ls = new LibroService();

        ls.editarLibro();
        
        

//        for (int i = 0; i < 1; i++) {
//            
//              ls.crearLibro();
//              
//        }
    }

}
